package com.wora.bffagendador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoraApplication.class, args);
    }

}
