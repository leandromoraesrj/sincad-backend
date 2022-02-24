package com.github.leandromoraesrj.sincadbackend.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Profile("test")
public class testConfiguration {
	// Para Injetar um parâmetro de aplication.properties
	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.servlet.context-path}")
	private String applicationConext;

	@Value("${spring.profiles.active}")
	private String applicationProfile;

	@Bean
	public void teste() {
		log.info("Nome da Aplicação: " + applicationName);
		log.info("Contexto da Aplicação: " + applicationConext);
		log.info("Ambiente da Aplicação: " + applicationProfile);
	}
}