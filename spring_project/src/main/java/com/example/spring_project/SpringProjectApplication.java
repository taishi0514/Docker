package com.example.spring_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringProjectApplication {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

}
