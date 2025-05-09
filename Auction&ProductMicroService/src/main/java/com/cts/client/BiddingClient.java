package com.cts.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.dto.Bidding;

@FeignClient(name = "Auction-Result", url = "http://localhost:6078/auctionBid")
public interface BiddingClient {

	@GetMapping("/getResult/{id}")
	public Bidding findResult(@PathVariable("id") int auctionId);
}
