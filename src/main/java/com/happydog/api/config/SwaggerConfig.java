package com.happydog.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Pets App",
        version = "1.0",
        description = "RESTful API for Pets Backend"
    )
)
public class SwaggerConfig {

}
