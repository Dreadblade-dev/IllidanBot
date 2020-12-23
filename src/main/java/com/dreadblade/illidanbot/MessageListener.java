package com.dreadblade.illidanbot;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageListener extends ListenerAdapter {
    @Value("${discord.prefix}")
    private String prefix;

    private static final String PING_COMMAND = "ping";

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith(prefix + PING_COMMAND)) {
            TextChannel channel = event.getChannel();
            channel.sendMessage("Pong!").queue();
        }
    }
}
