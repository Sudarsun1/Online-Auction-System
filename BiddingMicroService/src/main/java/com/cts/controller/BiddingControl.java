package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Bidding;
import com.cts.service.BiddingService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/auctionBid")
@NoArgsConstructor
public class BiddingControl {

	@Autowired
	BiddingService service;
	
	@PostMapping("/bid")
	public String makeBidding(@RequestBody Bidding bid) {
		return service.makeBidding(bid);
	}
	
	@GetMapping("/getResult/{id}")
	public Bidding findResult(@PathVariable("id") int auctionId) {
		return service.findResult(auctionId);
	}
}
