package com.dreadblade.illidanbot.utils;

import net.dv8tion.jda.api.entities.User;

public class DiscordUtils {
    public static String formatAsUser(User user) {
        return String.format("%s#%s", user.getName(), user.getDiscriminator());
    }
}
