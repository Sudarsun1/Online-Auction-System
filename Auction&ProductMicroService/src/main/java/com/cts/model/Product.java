package com.cts.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product_info")
public class Product {
	@Id
	@GeneratedValue
	private int productId;
	@jakarta.validation.constraints.NotNull
	private int sellerId;
	@jakarta.validation.constraints.NotNull
	private String productName;
	@jakarta.validation.constraints.NotNull
	private String productCategory;
	@jakarta.validation.constraints.NotNull
	private int initialBiddingAmount;
	private String productDescription;
	private LocalDateTime startTime;
	@jakarta.validation.constraints.NotNull
	private LocalDateTime endTime;
	private String status;
	private int winnerId;
	private int winningAmount;
}
