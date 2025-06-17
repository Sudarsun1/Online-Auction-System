package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.cts.client.ProductClient;
import com.cts.exception.LowBidException;
import com.cts.model.Bidding;
import com.cts.repository.BiddingRepository;
import com.cts.service.BiddingServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BiddingServiceImplTests {

    @Mock
    private BiddingRepository repository;

    @Mock
    private ProductClient client;

    @InjectMocks
    private BiddingServiceImpl biddingService;

    @Test
    void testMakeBidding_Success() throws LowBidException {
        Bidding bid = new Bidding();
        bid.setAuctionId(1);
        bid.setBiddingAmount(500);

        when(client.getStartingBidAmount(1)).thenReturn(400);
        when(repository.save(bid)).thenReturn(bid);

        String result = biddingService.makeBidding(bid);
        assertEquals("The Bid is made Successfully", result);
    }

    @Test
    void testMakeBidding_LowBidException() {
        Bidding bid = new Bidding();
        bid.setAuctionId(1);
        bid.setBiddingAmount(300);

        when(client.getStartingBidAmount(1)).thenReturn(500);

        Exception exception = assertThrows(LowBidException.class, () -> {
            biddingService.makeBidding(bid);
        });

        assertEquals("The amount you bid is less than the minimum required bid which is 500", exception.getMessage());
    }

    @Test
    void testFindResult_Found() {
        Bidding bid = new Bidding();
        bid.setAuctionId(1);
        bid.setWinnerId(100);
        bid.setWinningAmount(1000);

        when(repository.findResult(1)).thenReturn(Optional.of(bid));

        Bidding result = biddingService.findResult(1);
        assertEquals(1, result.getAuctionId());
        assertEquals(100, result.getWinnerId());
        assertEquals(1000, result.getWinningAmount());
    }

    @Test
    void testFindResult_NotFound_DefaultValues() {
        when(repository.findResult(99)).thenReturn(Optional.empty());

        Bidding result = biddingService.findResult(99);
        assertEquals(0, result.getAuctionId());
        assertEquals(0, result.getWinnerId());
        assertEquals(1, result.getWinningAmount());
    }
}
