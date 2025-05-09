package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.SellerReview;
import com.cts.model.UserReview;
import com.cts.repository.SellerRepository;
import com.cts.repository.UserRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	SellerRepository sellerRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public String giveFeedbackToUser(UserReview review) {
		userRepo.save(review);
		return "Got the Feedback";
	}
	
	@Override
	public String giveFeedbackToSeller(SellerReview review) {
		sellerRepo.save(review);
		return "Got the Feedback";
	}

	@Override
	public float getUserRating(int userId) {
		List<UserReview> feedbacks = userRepo.findByUserId(userId);
		float totalRating = 0;
		for (UserReview feedback : feedbacks) {
            totalRating += feedback.getUserRating();
        }
		return totalRating / feedbacks.size();
	}

	@Override
	public float getSellerRating(int sellerId) {
		List<SellerReview> feedbacks = sellerRepo.findBySellerId(sellerId);
		float totalRating = 0;
		for (SellerReview feedback : feedbacks) {
            totalRating += feedback.getSellerRating();
        }
		return totalRating / feedbacks.size();
	}

	@Override
	public String deleteUserFeedbackById(int feedbackId) {
		userRepo.deleteById(feedbackId);
		return "Successfully deleted the Feedback";
	}

	@Override
	public String deleteSellerFeedbackById(int feedbackId) {
		sellerRepo.deleteById(feedbackId);
		return "Successfully deleted the Feedback";
	}

	@Override
	public Optional<UserReview> viewUserReview(int feedbackId) {
		return userRepo.findById(feedbackId);
	}

	@Override
	public Optional<SellerReview> viewSellerReview(int feedbackId) {
		return sellerRepo.findById(feedbackId);
	}

}
