package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.UserReview;

public interface UserRepository extends JpaRepository<UserReview, Integer>{
	
	public List<UserReview> findByUserId(int userId);

}
