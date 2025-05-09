package com.cts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payment_info")
public class Payment {

	@Id
	@GeneratedValue
	private int transactionId;
	private int biddingId;
	private int auctionId;
	private int amount;
	
}
