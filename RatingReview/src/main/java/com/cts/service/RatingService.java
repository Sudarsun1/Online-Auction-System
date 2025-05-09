package com.cts.service;

import java.util.Optional;

import com.cts.model.SellerReview;
import com.cts.model.UserReview;

public interface RatingService {

	public String giveFeedbackToUser(UserReview review);
	
	public String giveFeedbackToSeller(SellerReview review);
	
	public Optional<UserReview> viewUserReview(int feedbackId);
	
	public Optional<SellerReview> viewSellerReview(int feedbackId);
	
	public String deleteUserFeedbackById(int feedbackId);
	
	public String deleteSellerFeedbackById(int feedbackId);
	
	public float getUserRating(int userId);
	
	public float getSellerRating(int sellerId);
}
