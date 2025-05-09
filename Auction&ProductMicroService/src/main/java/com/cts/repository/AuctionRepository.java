package com.cts.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.model.Auction;

import jakarta.transaction.Transactional;


public interface AuctionRepository extends JpaRepository<Auction, Integer>{

	
	@Query("SELECT a FROM Auction a WHERE a.productCategory = :category")
	public List<Auction> fetchByCategoryInAuction(@Param("category") String productCategory);
	
	@Query("SELECT a FROM Auction a WHERE a.currentBid BETWEEN :minPrice AND :maxPrice")
	public List<Auction> fetchByPriceInAuction( @Param("minPrice") int minPrice,@Param("maxPrice") int maxPrice);
	
	@Query("SELECT a FROM Auction a WHERE :mins > (SELECT TIMESTAMPDIFF(MINUTE, :currentTime, a.endTime)) ")
	public List<Auction> fetchByMinimumTimeLeftInMins(@Param("mins") int timeLeftInMins, @Param("now") LocalDateTime currentTime);

	@Transactional
	@Modifying
    @Query("UPDATE Auction a SET a.status = 'Completed' WHERE a.endTime <= :time")
	public void changeStatusToCompletedInAuction(@Param("time") LocalDateTime currentTime);
	
	@Query("DELETE FROM Auction a WHERE a.status = 'Completed' ")
	public void deleteAuction();
	
	@Query("SELECT a.auctionId FROM Auction a WHERE a.status = 'Completed' ")
	public int[] getCompletedAuctionId();
	
	@Transactional
	@Modifying
    @Query("UPDATE Auction a SET a.winnerId = :winnerId, a.winningAmount = :winningAmount")
	public void updateWinnerInAuction(@Param("winnerId")int winnerId,@Param("winningAmount") int winningAmount);
}
