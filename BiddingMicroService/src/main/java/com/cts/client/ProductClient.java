package com.cts.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Bidding-amount", url = "http://localhost:5056/auctionProduct")
public interface ProductClient {

	@GetMapping("/fetchBiddingAmountByAuctionId/{id}")
	public int getStartingBidAmount(@PathVariable("id") int productId);
}
