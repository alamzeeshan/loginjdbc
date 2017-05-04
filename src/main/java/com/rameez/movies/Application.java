package com.rameez.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.rameez.movies.web,com.rameez.movies.service,com.rameez.movies.dao")
public class Application {	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
