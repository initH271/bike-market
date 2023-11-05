package com.bike.bikeorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.bike.bikecommon.client"})
public class BikeOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BikeOrderApplication.class, args);
    }
}