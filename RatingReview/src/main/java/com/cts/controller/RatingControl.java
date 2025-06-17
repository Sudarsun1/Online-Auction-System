package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Notification;
import com.cts.model.SellerReview;
import com.cts.model.UserReview;
import com.cts.service.NotificationService;
import com.cts.service.RatingService;

@RestController
@RequestMapping("/auctionRating")
public class RatingControl {

	@Autowired
	RatingService service;
	@Autowired
    private NotificationService notificationService;

    @GetMapping("/getAllNotification")
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public Optional<Notification> getNotificationById(@PathVariable int id) {
        return notificationService.getNotificationById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getNotificationsByUserId(@PathVariable int userId) {
        return notificationService.getNotificationsByUserId(userId);
    }
	
    @GetMapping("/seller/{sellerId}")
    public List<Notification> getNotificationsBySellerId(@PathVariable int sellerId) {
        return notificationService.getNotificationsBySellerId(sellerId);
    }

    @PostMapping("/create")
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.saveNotification(notification);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNotification(@PathVariable int id) {
        notificationService.deleteNotification(id);
    }
    
	@PostMapping("/saveUserFeedback")
	public String giveFeedbackToUser(@RequestBody UserReview review) {
		return service.giveFeedbackToUser(review);
	}
	
	@PostMapping("/saveSellerFeedback")
	public String giveFeedbackToSeller(@RequestBody SellerReview review) {
		return service.giveFeedbackToSeller(review);
	}
	
	@DeleteMapping("/deleteUserFeedbackById/{id}")
	public String deleteUserFeedbackById(@PathVariable("id") int feedbackId) {
		return service.deleteUserFeedbackById(feedbackId);
	}
	
	@DeleteMapping("/deleteSellerFeedbackById/{id}")
	public String deleteSellerFeedbackById(@PathVariable("id") int feedbackId) {
		return service.deleteSellerFeedbackById(feedbackId);
	}
	
	@GetMapping("/getUserRating/{id}")
	public float getUserRating(@PathVariable("id") int userId) {
		return service.getUserRating(userId);
	}
	
	@GetMapping("/getSellerRating/{id}")
	public float getSellerRating(@PathVariable("id") int sellerId) {
		return service.getSellerRating(sellerId);
	}
	
	@GetMapping("/getUserReview/{id}")
	public Optional<UserReview> viewUserReview(@PathVariable("id") int feedbackId){
		return service.viewUserReview(feedbackId);
	}
	
	@GetMapping("/getSellerReview/{id}")
	public Optional<SellerReview> viewSellerReview(@PathVariable("id") int feedbackId){
		return service.viewSellerReview(feedbackId);
	}
}
