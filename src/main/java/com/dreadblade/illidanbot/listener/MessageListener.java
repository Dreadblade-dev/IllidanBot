package com.dreadblade.illidanbot.listener;

import com.dreadblade.illidanbot.command.common.PingCommand;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageListener extends ListenerAdapter {
    @Value("${discord.prefix}")
    private String prefix;

    private PingCommand pingCommand;

    @Autowired
    public MessageListener(PingCommand pingCommand) {
        this.pingCommand = pingCommand;
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith(prefix + pingCommand.getName())) {
            pingCommand.execute(event);
        }
    }
}
