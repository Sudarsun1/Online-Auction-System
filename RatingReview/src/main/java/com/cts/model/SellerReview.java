package com.cts.model;

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
@Table(name = "sellerRating")
public class SellerReview {

	@Id
	@GeneratedValue
	private int feedbackId;
	private int userId;
	private int sellerId;
	private int sellerRating;
	private int userRating;
	private String reviews;

}
