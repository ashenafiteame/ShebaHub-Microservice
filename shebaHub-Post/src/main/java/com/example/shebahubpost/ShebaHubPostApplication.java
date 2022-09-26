package com.example.shebahubpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ShebaHubPostApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShebaHubPostApplication.class, args);
	}

}
