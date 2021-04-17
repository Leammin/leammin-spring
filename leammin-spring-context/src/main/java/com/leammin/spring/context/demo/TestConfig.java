package com.leammin.spring.context.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public MyTestBean myTestBean() {
        return new MyTestBean();
    }
}
