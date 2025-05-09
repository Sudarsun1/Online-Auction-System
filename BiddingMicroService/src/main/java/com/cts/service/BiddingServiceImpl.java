package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Bidding;
import com.cts.repository.BiddingRepository;

@Service
public class BiddingServiceImpl implements BiddingService{

	@Autowired
	BiddingRepository repository;
	
	@Override
	public String makeBidding(Bidding bid) {
		repository.save(bid);
		return "The Bid is made Successfully";
	}

	@Override
	public Bidding findResult(int auctionId) {
		Bidding bid = new Bidding();
		bid = repository.findResult(auctionId);
		repository.updateWinner(bid.getAuctionId(),bid.getWinnerId(),bid.getWinningAmount());
		return bid;
	}

}
