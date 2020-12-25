package com.dreadblade.illidanbot.command.common;

import com.dreadblade.illidanbot.command.AbstractCommand;
import com.dreadblade.illidanbot.command.DiscordCommand;
import com.dreadblade.illidanbot.utils.DiscordUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

@DiscordCommand(
        key = "discord.command.common.ping.key",
        description =  "discord.command.common.ping.description"
)
public class PingCommand extends AbstractCommand {
    @Override
    public void execute(GuildMessageReceivedEvent event) {
        JDA jda = event.getJDA();

        EmbedBuilder builder = messageService.getBaseEmbed();

        builder.setTitle(messageService.getMessage("discord.command.common.ping.title"));
        builder.setFooter(DiscordUtils.formatAsUser(jda.getSelfUser()));

        jda.getRestPing().queue(
                ping -> {
                    builder.addField(getPingField(ping, jda.getGatewayPing()));
                            event.getChannel()
                                    .sendMessage(builder.build()).queue();
                });
    }

    private MessageEmbed.Field getPingField(long restPing, long gatewayPing) {
        return new MessageEmbed.Field(messageService.getMessage("discord.command.common.ping.field.title"),
                messageService.getMessage("discord.command.common.ping.response", restPing, gatewayPing), true);
    }
}
