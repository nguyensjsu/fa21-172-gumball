package com.example.candyshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CandyShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandyShopApplication.class, args);
	}

}
