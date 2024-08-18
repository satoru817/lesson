package com.example.universityApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.universityApp.entity")
@ComponentScan("com.example.universityApp.controller")
public class UniversityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityAppApplication.class, args);
	}

}
