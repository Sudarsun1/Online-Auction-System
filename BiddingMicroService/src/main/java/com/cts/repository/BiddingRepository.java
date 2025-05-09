package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.model.Bidding;

public interface BiddingRepository extends JpaRepository<Bidding, Integer>{

	@Query("SELECT b.userId, b.biddingAmount FROM Bidding b WHERE b.auctionId = :auctionId ORDER BY b.biddingAmount DESC LIMIT 1")
	public Bidding findResult(@Param("auctionId") int auctionId);
	
	@Modifying
    @Query("UPDATE Bidding b SET b.winnerId = :winnerId, b.winningAmount = :winningAmount WHERE b.auctionId = :auctionId")
	public void updateWinner(@Param("auctionId") int auctionId,@Param("winnerId") int winnerId,@Param("winningAmount") int winningAmount);
}
