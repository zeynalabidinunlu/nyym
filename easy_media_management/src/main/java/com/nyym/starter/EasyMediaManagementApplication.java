package com.nyym.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "com.nyym")
@ComponentScan(basePackages = "com.nyym")
@EnableJpaRepositories(basePackages = "com.nyym")
@SpringBootApplication
public class EasyMediaManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyMediaManagementApplication.class, args);
	}

}
