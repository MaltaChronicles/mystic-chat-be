package it.mystic.chat.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi config() {
        return GroupedOpenApi.builder()
                .group("Config")
                .pathsToMatch("/**/config/**/")
                .build();
    }

    @Bean
    public GroupedOpenApi off() {
        return GroupedOpenApi.builder()
                .group("OFF")
                .pathsToMatch("/**/off/**/")
                .build();
    }

    @Bean
    public GroupedOpenApi on() {
        return GroupedOpenApi.builder()
                .group("ON")
                .pathsToMatch("/**/on/**/")
                .build();
    }

    @Bean
    public OpenAPI openApiServers() {
        return new OpenAPI().servers(
            List.of(
                new io.swagger.v3.oas.models.servers.Server()
                    .url("http://localhost:8080")
                    .description("Server di sviluppo"),
                new io.swagger.v3.oas.models.servers.Server()
                        .url("")
                        .description("Server di produzione")
            )
        );
    }
}
