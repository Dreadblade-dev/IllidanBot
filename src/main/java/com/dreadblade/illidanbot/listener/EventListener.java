package com.dreadblade.illidanbot.listener;

import com.dreadblade.illidanbot.config.DiscordConfig;
import com.dreadblade.illidanbot.service.MessageService;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class EventListener extends ListenerAdapter {
    @Autowired
    protected DiscordConfig discordConfig;

    @Autowired
    protected MessageService messageService;
}
