package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.model.SellerReview;


public interface SellerRepository extends JpaRepository<SellerReview, Integer>{

	@Query("SELECT r FROM SellerReview r where r.userId = :id")
	public List<SellerReview> findBySellerId(@Param("id") int sellerId);
	
}
