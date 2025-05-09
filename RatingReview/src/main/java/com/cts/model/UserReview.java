package com.cts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "userRating")
@NoArgsConstructor
@AllArgsConstructor
public class UserReview {

	@Id
	@GeneratedValue
	private int feedbackId;
	private int userId;
	private int sellerId;
	private int sellerRating;
	private int userRating;
	private String reviews;
}
