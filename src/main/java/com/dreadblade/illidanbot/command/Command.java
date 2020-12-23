package com.dreadblade.illidanbot.command;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public interface Command {
    void execute(GuildMessageReceivedEvent event);
}
