package com.dreadblade.illidanbot.config;

import com.dreadblade.illidanbot.listener.DiscordEventListener;
import com.dreadblade.illidanbot.listener.EventListener;
import net.dv8tion.jda.api.JDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventListenerConfig {
    private ApplicationContext context;
    private JDA jda;

    @Autowired
    public EventListenerConfig(ApplicationContext context, JDA jda) {
        this.context = context;
        this.jda = jda;
    }

    @Bean
    public void registerListeners() {
        EventListener[] listeners = context.getBeansWithAnnotation(DiscordEventListener.class)
                .values()
                .stream()
                .map(l -> (EventListener) l)
                .toArray(EventListener[]::new);

        jda.addEventListener(listeners);
    }
}
