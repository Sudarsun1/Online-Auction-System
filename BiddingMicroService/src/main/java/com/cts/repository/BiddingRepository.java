package com.cts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.model.Bidding;

import jakarta.transaction.Transactional;

public interface BiddingRepository extends JpaRepository<Bidding, Integer>{


	@Transactional
	@Query("SELECT b FROM Bidding b WHERE b.auctionId = :auctionId ORDER BY b.biddingAmount DESC LIMIT 1")
	public Optional<Bidding> findResult(@Param("auctionId") int auctionId);

	
	@Transactional
	@Modifying
    @Query("UPDATE Bidding b SET b.winnerId = :winnerId, b.winningAmount = :winningAmount WHERE b.auctionId = :auctionId")
	public void updateWinner(@Param("auctionId") int auctionId,@Param("winnerId") int winnerId,@Param("winningAmount") int winningAmount);
}
