package com.cts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.model.UserReview;

public interface UserRepository extends JpaRepository<UserReview, Integer>{
	
	@Query("SELECT r FROM UserReview r where r.userId = :id")
	public List<UserReview> findByUserId(@Param("id") int userId);

	@Query("SELECT r FROM UserReview r where r.feedbackId = :id")
	public Optional<UserReview> viewUserReview(@Param("id") int feedbackId);
}
