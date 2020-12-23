package com.dreadblade.illidanbot.command.common;

import com.dreadblade.illidanbot.command.AbstractCommand;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component
public class PingCommand extends AbstractCommand {
    @Override
    public void execute(GuildMessageReceivedEvent event) {
        TextChannel channel = event.getChannel();
        channel.sendMessage(messageService.getMessage("discord.command.common.ping.response")).queue();
    }

    public String getName() {
        return messageService.getMessage("discord.command.common.ping.key");
    }
}
