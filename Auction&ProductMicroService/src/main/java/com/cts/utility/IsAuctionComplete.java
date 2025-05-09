package com.cts.utility;

import org.springframework.beans.factory.annotation.Autowired;

import com.cts.service.ProductService;

public class IsAuctionComplete implements Runnable{

	@Autowired
	ProductService service;
	
	@Override
	public void run() {
		try {
			System.out.println("Thread is running every 5 sec");
			service.endAuction();
        } catch (Exception e) {
            e.printStackTrace();  // Log any issues
        }
		
	}

}
