package com.meusjogos.gerenciador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc//http://localhost:8080/swagger-ui/index.html
@SpringBootApplication
public class GerenciadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GerenciadorApplication.class, args);
    }

}
