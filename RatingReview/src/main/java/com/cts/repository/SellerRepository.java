package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.SellerReview;


public interface SellerRepository extends JpaRepository<SellerReview, Integer>{

	public List<SellerReview> findBySellerId(int sellerId);
	
}
