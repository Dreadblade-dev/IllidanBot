package com.dreadblade.illidanbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class IllidanBotApplication {
	@Value("${discord.token}")
	private String token;

	@Autowired
	public JDA jda(MessageListener messageListener) throws LoginException {
		JDA jda = JDABuilder.createDefault(token).addEventListeners(messageListener).build();

		return jda;
	}

	public static void main(String[] args) {
		SpringApplication.run(IllidanBotApplication.class, args);
	}
}
