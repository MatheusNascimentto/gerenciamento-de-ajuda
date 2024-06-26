package com.gerenciamento.solidariza.config.swagger;


import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenApi() {
        return new CustomOpenApiConfiguration("Solidariza").buider();
      }
    }
