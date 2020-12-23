package com.dreadblade.illidanbot.service;

import com.dreadblade.illidanbot.config.DiscordConfig;
import net.dv8tion.jda.api.EmbedBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Locale;

@Service
public class MessageService {
    private ApplicationContext context;
    private DiscordConfig discordConfig;

    @Autowired
    public MessageService(ApplicationContext context, DiscordConfig discordConfig) {
        this.context = context;
        this.discordConfig = discordConfig;
    }

    public EmbedBuilder getBaseEmbed() {
        return new EmbedBuilder().setColor(Color.decode(discordConfig.getDefaultAccentColor()));
    }

    public String getMessage(String key, Object... args) {
        return getMessageByLocale(key, null, args);
    }

    public String getMessageByLocale(String key, Locale locale, Object... args) {
        if (locale == null) {
            locale = discordConfig.getDefaultLocale();
        }

        return context.getMessage(key, args, key, locale);
    }

    public String getEnumTitle(Enum<?> value) {
        return getEnumTitle(value, null);
    }

    public String getEnumTitle(Enum<?> value, Locale locale) {
        if (value == null) {
            return null;
        }

        return getMessageByLocale(value.getClass().getName() + "." + value.name(), locale);
    }
}
