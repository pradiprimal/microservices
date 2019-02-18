package com.pet.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PetDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetDetailsApplication.class, args);
	}

}

