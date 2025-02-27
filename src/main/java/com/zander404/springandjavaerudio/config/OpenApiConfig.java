package com.zander404.springandjavaerudio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Spring And Java API")
                .version("1.0")
                .description("Spring And Java API")
                .termsOfService("https://github.com/zander404/springandjavaerudio")
                .license(
                        new License()
                                .name("Apache 2.0")
                                .url("http://localhost:8080/docs/")
                )
        );
    }
}
