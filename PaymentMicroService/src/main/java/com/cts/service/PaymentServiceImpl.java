package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Payment;
import com.cts.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentRepository repository;
	
	@Override
	public String makePayment(Payment payment) {
		repository.save(payment);
		return "Payment is Successfully Completed";
	}

}
