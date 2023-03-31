package com.javainuse;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "DEMO API",
                version = "2.0",
                description = "DEMO INFORMATION"
        ),
        servers = {
                @Server(
                        url = "${demo.api.url}",
                        description = "DEMO API server"
                )
        },
        externalDocs = @ExternalDocumentation(
                description = "Documentation",
                url = "https://example.com/docs"
        )
)
public class SwaggerSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerSpringDemoApplication.class, args);
    }

}