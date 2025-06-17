package com.cts.service;

import java.util.List;

import com.cts.model.Bidding;

public interface BiddingService {
//	public String update(Bidding bid)

	public String makeBidding(Bidding bid);
	
	public Bidding findResult(int auctionId);
	
	public List<Bidding> getAllBids();
	
}
