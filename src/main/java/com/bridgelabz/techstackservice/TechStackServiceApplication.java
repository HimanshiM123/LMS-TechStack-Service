package com.bridgelabz.techstackservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TechStackServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechStackServiceApplication.class, args);
    }

}
