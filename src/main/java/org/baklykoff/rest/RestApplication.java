package org.baklykoff.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.io.IOException;

@SpringBootApplication
@ComponentScan({"org.baklykoff.rest.controllers", "org.baklykoff.rest.service","org.baklykoff.rest.exception","org.baklykoff.rest.config"})
@EntityScan({"org.baklykoff.rest.models"})
@EnableJpaRepositories("org.baklykoff.rest.repository")
public class RestApplication {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("cmd /c start mysqld --console");
        }catch (IOException e){
            System.out.println("No mysql in path(environment variables)");
        }
        SpringApplication.run(RestApplication.class, args);

    }
}
