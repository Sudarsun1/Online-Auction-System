package com.cts.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.model.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Transactional
	@Modifying
    @Query("UPDATE Product p SET p.status = 'Completed' WHERE p.endTime <= :time")
	public int changeStatusToCompletedInProduct(@Param("time") LocalDateTime currentTime);
	
	@Transactional
    @Modifying
    @Query("UPDATE Product p SET p.status = 'Available' WHERE p.productId = :productId")
    public void startAuction1(@Param("productId") int productId);
	
	@Transactional
	@Modifying
    @Query("UPDATE Product p SET p.winnerId = :winnerId, p.winningAmount = :winningAmount")
	public void updateWinnerInProduct(@Param("winnerId")int winnerId,@Param("winningAmount") int winningAmount);

	public List<Product> findBySellerId(int sellerId);

}
