package com.productservice.productservice.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ObjectMapprtConfiigurtation {


    @Bean
    public ObjectMapper productObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }
}
