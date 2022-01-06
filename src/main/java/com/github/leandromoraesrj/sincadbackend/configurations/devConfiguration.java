package com.github.leandromoraesrj.sincadbackend.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class devConfiguration {
	//Para Injetar um parâmetro de aplication.properties
	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.servlet.context-path}")
	private String applicationConext;
	
	@Value("${spring.profiles.active}")
	private String applicationProfile;
		
	//Para o Logger exibir mensagem no console
	private static Logger logger = LoggerFactory.getLogger(devConfiguration.class);
	
	@Bean
	public void teste() {
		logger.info("Nome da Aplicação: " + applicationName);
		logger.info("Contexto da Aplicação: " + applicationConext);
		logger.info("Ambiente da Aplicação: " + applicationProfile);
	}
}
