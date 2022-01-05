package com.github.leandromoraesrj.sincadbackend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SincadBackendApplication {
	//Para Injetar um parâmetro de aplication.properties
	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.servlet.context-path}")
	private String applicationConext;
	
	@Value("${spring.profiles.active}")
	private String applicationProfile;

	public static void main(String[] args) {
		SpringApplication.run(SincadBackendApplication.class, args);
	}
	
	//Para obter informações da aplicação, por exemplo, o contexto 
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String teste() {
		return "Nome da Aplicação: " + applicationName + "\n" + "Contexto da Aplicação: " + applicationConext + "\n" + "Ambiente da Aplicação: " + applicationProfile;
	}
}
