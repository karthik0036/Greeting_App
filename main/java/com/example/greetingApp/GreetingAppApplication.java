package com.example.greetingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingAppApplication {

	public static void main(String[] args) {
		System.out.println("App Launched");
		SpringApplication.run(GreetingAppApplication.class, args);
	}

}
