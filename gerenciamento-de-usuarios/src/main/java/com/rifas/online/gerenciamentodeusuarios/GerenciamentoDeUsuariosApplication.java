package com.rifas.online.gerenciamentodeusuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class GerenciamentoDeUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoDeUsuariosApplication.class, args);
	}
}
