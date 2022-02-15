package com.github.leandromoraesrj.sincadbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SincadBackendApplication implements CommandLineRunner {	
	@Value("${spring.profiles.active}")
	private String applicationProfile;
	
	//Para o Logger exibir mensagem no console
	private static Logger logger = LoggerFactory.getLogger(SincadBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SincadBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (applicationProfile.equals("test")) {
			logger.info("Testando CommandRunner");			
		}
	}
}
