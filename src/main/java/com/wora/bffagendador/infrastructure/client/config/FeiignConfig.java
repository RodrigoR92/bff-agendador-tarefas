package com.wora.bffagendador.infrastructure.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeiignConfig {

    @Bean
    public FeignError feignError() {
        return new FeignError();
    }
}
