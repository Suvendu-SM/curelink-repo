package com.newsletter.subscribe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.newsletter.subscribe")

@EnableEurekaClient
public class SubscribeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscribeServiceApplication.class, args);
	}

}
