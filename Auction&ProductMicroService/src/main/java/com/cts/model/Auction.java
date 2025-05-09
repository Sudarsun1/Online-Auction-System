package com.cts.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "auction_info")
public class Auction {

	@Id
	@GeneratedValue
	private int auctionId;
	private int productId;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int currentBid;
	private int winnerId;
	private int winningAmount;
	private String productName;
	private String productCategory;
	private String productDescription;
	private String status;

}
