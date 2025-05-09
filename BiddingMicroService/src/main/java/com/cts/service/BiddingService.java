package com.cts.service;

import com.cts.model.Bidding;

public interface BiddingService {

	public String makeBidding(Bidding bid);
	
	public Bidding findResult(int auctionId);
	
}
