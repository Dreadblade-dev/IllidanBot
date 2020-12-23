package com.dreadblade.illidanbot.command;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component
public class PingCommand implements Command {
    @Override
    public void execute(GuildMessageReceivedEvent event) {
        TextChannel channel = event.getChannel();
        channel.sendMessage("Pong!").queue();
    }

    public String getName() {
        return "ping";
    }
}
