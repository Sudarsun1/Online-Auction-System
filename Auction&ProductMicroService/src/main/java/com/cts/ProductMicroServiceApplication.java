package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.cts.client")
@ComponentScan(basePackages = "com.cts")
public class ProductMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMicroServiceApplication.class, args);
	}

}
