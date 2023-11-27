package it.mystic.chat.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
