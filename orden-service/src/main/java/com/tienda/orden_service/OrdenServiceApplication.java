package com.tienda.orden_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.tienda.orden.client")
public class OrdenServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrdenServiceApplication.class, args);
    }
}
