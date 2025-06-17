package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cts")
public class RatingReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingReviewApplication.class, args);
	}

}
