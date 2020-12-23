package com.dreadblade.illidanbot.config;

import com.dreadblade.illidanbot.listener.MessageListener;
import lombok.Data;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.LoginException;
import java.util.Locale;

@Configuration
@Data
public class DiscordConfig {
    @Value("${discord.token}")
    private String token;

    @Value("${discord.prefix}")
    private String defaultPrefix;

    @Value("${discord.default.color}")
    private String defaultAccentColor;

    @Value("${discord.default.locale}")
    private Locale defaultLocale;

    private final MessageListener messageListener;

    @Autowired
    public DiscordConfig(MessageListener messageListener) {
        this.messageListener = messageListener;
    }

    @Bean
    public JDA jda() throws LoginException {
        return JDABuilder.createDefault(token).addEventListeners(messageListener).build();
    }
}
