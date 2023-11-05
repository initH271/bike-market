package com.bike.bikeweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.bike.bikecommon.client"})     // 开启Feign功能
public class BikeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikeWebApplication.class, args);
    }

}
