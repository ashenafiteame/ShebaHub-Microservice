package com.example.shebahubuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShebaHubUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShebaHubUserApplication.class, args);
    }

}
