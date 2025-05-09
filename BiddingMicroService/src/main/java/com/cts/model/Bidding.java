package com.cts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "bidding")
public class Bidding {

	@Id
	@GeneratedValue
	private int biddingId;
	@NotNull
	private int auctionId;
	@NotNull
	private int biddingAmount;
	@NotNull
	private int userId;
	private int winnerId;
	private int winningAmount;
	
}
