package com.pokemon.pokemoncards.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    @Bean
    public RestTemplate provideRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("username", "password"));
        return restTemplate;
    }
/*
    @Bean
    public RestOperations restOperations(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.basicAuthentication("username", "password").build();
    }*/
}
