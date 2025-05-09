package com.cts;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.cts.utility.IsAuctionComplete;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.cts.client")
@ComponentScan(basePackages = "com.cts")
public class ProductMicroServiceApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ProductMicroServiceApplication.class, args);
	    ScheduledExecutorService exeService = Executors.newScheduledThreadPool(1);
		exeService.scheduleWithFixedDelay(new IsAuctionComplete(), 5, 5, TimeUnit.SECONDS);
	}

}
