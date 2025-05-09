package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Payment;
import com.cts.service.PaymentService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/auctionPayment")
@NoArgsConstructor
public class PaymentControl {

	@Autowired
	PaymentService service;
	
	@PostMapping("/pay")
	public String makePayment(@RequestBody Payment payment) {
		return service.makePayment(payment);
	}
}
