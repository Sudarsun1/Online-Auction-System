package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.client.ProductClient;
import com.cts.exception.LowBidException;
import com.cts.model.Bidding;
import com.cts.repository.BiddingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BiddingServiceImpl implements BiddingService{

	@Autowired
	BiddingRepository repository;
	
	@Autowired
	ProductClient client;
	
	
	
	@Override
	public String makeBidding(Bidding bid) throws LowBidException{
		int amount = client.getStartingBidAmount(bid.getAuctionId());
		if(amount > bid.getBiddingAmount()) {
			throw new LowBidException("The amount you bid is less than the minimum required bid which is "+amount);
		}
		else {
		repository.save(bid);
		return "The Bid is made Successfully";
		}
	}

	@Override
	public Bidding findResult(int auctionId) {
		Optional<Bidding> bidOptional = repository.findResult(auctionId);
	    
	    // Get Bidding object, default to a new instance if not found
	    Bidding bid = bidOptional.orElseGet(() -> {
	        Bidding defaultBid = new Bidding();
	        defaultBid.setAuctionId(0);
	        defaultBid.setWinnerId(0);
	        defaultBid.setWinningAmount(1);
	        return defaultBid;
	    });
		System.out.println("This is the details of bid "+bid.getBiddingAmount()+"...........................................");
	    // Update winner information
	    repository.updateWinner(bid.getAuctionId(), bid.getUserId(), bid.getBiddingAmount());
		
		return bid;
	}
	
	public List<Bidding> getAllBids(){
		List<Bidding> bids = repository.findAll();
		return bids;
	}

}
