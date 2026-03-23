package com.bank.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI basicOpenApi() {
		return new OpenAPI().info(
				new Info().title("Banking Management System").version("2.0.0").description("Banking Application"));
	}
}
