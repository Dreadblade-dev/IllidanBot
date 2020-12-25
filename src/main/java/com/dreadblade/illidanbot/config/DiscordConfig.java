package com.dreadblade.illidanbot.config;

import lombok.Data;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
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

    @Bean
    public JDA jda() throws LoginException {
        return JDABuilder.createDefault(token).build();
    }
}
