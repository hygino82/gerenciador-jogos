package com.jogos.lista.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Config {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jogos.lista"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
			
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Gerenciador de jogos API",
				"Gerenciamento de jogos",
				"API v1",
				"Termos de serviço.",
				new Contact("Adroaldo", "www.github.com/hygino82","hygino82@gmail.com"),
				"licence", "url",Collections.emptyList()
				
				);
				
	}
}
