package com.saimuralikrishna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by saimuralikrishnasriadibhatla on 6/28/17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).pathMapping("/").apiInfo(apiInfo());
    }
    private ApiInfo apiInfo(){
        Contact contact = new Contact("Sai MuraliKrishna SriAdibhatla","www.murali.com","murali@gmail.com");
        ApiInfo info = new ApiInfo("Car Tracker API", "A Simple API to track details of vehicles, their conditions and geoloactions", "1.0", "www.google.com", contact , "MIT", "http://www.mit.com");
        return info;
    }
}
