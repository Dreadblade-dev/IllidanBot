package com.dreadblade.illidanbot.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfig {
    @Bean
    public MessageSource messageSource() {
        var source = new ResourceBundleMessageSource();
        source.addBasenames("common-messages", "jda-messages");
        return source;
    }
}