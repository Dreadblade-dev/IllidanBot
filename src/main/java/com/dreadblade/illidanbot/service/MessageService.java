package com.dreadblade.illidanbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {
    private ApplicationContext context;

    @Autowired
    public MessageService(ApplicationContext context) {
        this.context = context;
    }

    public String getMessage(String key, Object... args) {
        return getMessageByLocale(key, null, args);
    }

    public String getMessageByLocale(String key, Locale locale, Object... args) {
        if (locale == null) {
            locale = Locale.ENGLISH;
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
