package com.joyuna.delivery.domain.common.web;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

//    @Bean
//    public GroupedOpenApi publicApi() {
//        return GroupedOpenApi.builder()
//                .group("com.joyuna.delivery")
//                .pathsToMatch("/**")
//                .build();
//    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Delivery service API")
                        .description("배달서비스 API 명세서입니다.")
                        .version("v0.0.1")
                        .contact(new Contact()
                                .name("joyuna")
                                .email("joayounga@gmail.com")
                                .url("https://joyuna.tistory.com/")
                        )
                );
    }
}
