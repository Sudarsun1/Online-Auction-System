package com.cts.utility;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cts.service.ProductService;

@Component
public class IsAuctionComplete{

	@Autowired
	ProductService service;
	ScheduledExecutorService exeService = Executors.newScheduledThreadPool(1);
	
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady() {
		try {
			exeService.scheduleAtFixedRate(this::runScheduledTask, 5, 5, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();  // Log any issues
        }
	}
	
	private void runScheduledTask()
	{
		System.out.println("Thread is running every 5 sec");
		service.endAuction();
	}

}
