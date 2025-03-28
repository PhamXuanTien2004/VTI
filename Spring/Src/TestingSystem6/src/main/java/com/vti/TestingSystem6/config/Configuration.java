package com.vti.TestingSystem6.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public ModelMapper initModelMapper() {
        return new ModelMapper();
    }
}