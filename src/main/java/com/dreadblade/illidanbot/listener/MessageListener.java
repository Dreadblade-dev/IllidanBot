package com.dreadblade.illidanbot.listener;

import com.dreadblade.illidanbot.command.Command;
import com.dreadblade.illidanbot.command.DiscordCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DiscordEventListener
public class MessageListener extends EventListener {
    private Map<String, Command> commands;

    @Autowired
    private void registerCommands(List<Command> commands) {
        this.commands = new HashMap<>();

        commands.stream().filter(e -> e.getClass().isAnnotationPresent(DiscordCommand.class)).forEach(cmd -> {
            DiscordCommand annotation = cmd.getClass().getAnnotation(DiscordCommand.class);
            String key = messageService.getMessage(annotation.key());
            this.commands.put(key, cmd);
        });

        this.commands = Collections.unmodifiableMap(this.commands);
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (!message.startsWith(discordConfig.getDefaultPrefix())) {
            return;
        }
        Command cmd = commands.get(message.substring(1));

        if (cmd != null) {
            Permission[] permissions = cmd.getClass().getAnnotation(DiscordCommand.class).permissions();
            if (event.getMember().hasPermission(permissions)) {
                cmd.execute(event);
            } else {
                TextChannel channel = event.getChannel();
                StringBuilder builder = new StringBuilder();

                builder.append(messageService.getMessage("discord.command.missing.permissions"));

                for (Permission permission : permissions) {
                    Member member = event.getMember();
                    if (!member.hasPermission(permission)) {
                        builder.append('\n')
                                .append(messageService.getEnumTitle(permission));
                    }
                }
                channel.sendMessage(builder.toString()).queue();
            }
        }
    }
}
