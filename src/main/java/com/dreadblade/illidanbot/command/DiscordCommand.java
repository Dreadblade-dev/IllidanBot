package com.dreadblade.illidanbot.command;

import net.dv8tion.jda.api.Permission;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
@Inherited
public @interface DiscordCommand {
    String key();

    String description();

    Permission[] permissions() default { Permission.MESSAGE_WRITE, Permission.MESSAGE_READ };
}
