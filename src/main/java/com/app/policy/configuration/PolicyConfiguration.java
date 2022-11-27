package com.app.policy.configuration;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PolicyConfiguration {
    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }
    @Bean
    Gson getGson(){return  new Gson();}
}
