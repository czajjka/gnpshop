package com.gnpshop.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("gnpshop")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gnpshop.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Webshop openApi")
                .description("Webshop REST Api with Swagger")
                .contact(new Contact("Gabriela Czajkowska", "https://github.com/czajjka", null))
                .contact(new Contact("Nikola Cywińska", "https://github.com/nicywi", null))
                .contact(new Contact("Piotr Falkowski", "https://github.com/PiotrEk-721", null))
                .version("0.0.1")
                .build();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void displaySwaggerURL(){
        System.out.println("Swagger-UI url:http://localhost:8080/swagger-ui/index.html");
    }
}
