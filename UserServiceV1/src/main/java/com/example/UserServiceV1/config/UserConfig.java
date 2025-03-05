package com.example.UserServiceV1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {


    @Bean
    public ObjectMapper objectMapper(){
        return  new ObjectMapper();
    }
}
