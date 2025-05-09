package com.cts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bidding {

	private int biddingId;
	private int auctionId;
	private int biddingAmount;
	private int userId;
	private int winnerId;
	private int winningAmount;
}
