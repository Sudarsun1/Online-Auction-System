package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import com.cts.client.BiddingClient;
import com.cts.exception.InvalidIdException;
import com.cts.model.Auction;
import com.cts.model.Product;
import com.cts.repository.AuctionRepository;
import com.cts.repository.ProductRepository;
import com.cts.service.ProductServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceImplTests {

    @Mock
    private ProductRepository productRepo;

    @Mock
    private AuctionRepository auctionRepo;

    @Mock
    private BiddingClient bidClient;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testSaveProduct() {
        Product product = new Product();
        when(productRepo.save(product)).thenReturn(product);
        String result = productService.saveProduct(product);
        assertEquals("Product Saved Successfully", result);
    }

    @Test
    void testViewAllProductsInAuction() {
        List<Auction> mockAuctions = Arrays.asList(new Auction(), new Auction());
        when(auctionRepo.findAll()).thenReturn(mockAuctions);
        List<Auction> result = productService.viewAllProductsinAuction();
        assertEquals(2, result.size());
    }

    @Test
    void testGetAnyProductById_Found() throws InvalidIdException {
        Product product = new Product();
        when(productRepo.findById(1)).thenReturn(Optional.of(product));
        Optional<Product> result = productService.getAnyProductById(1);
        assertEquals(Optional.of(product), result);
    }

    

    @Test
    void testGetStartingBidAmount() {
        when(auctionRepo.getInitialBidAmount(1)).thenReturn(500);
        int result = productService.getStartingBidAmount(1);
        assertEquals(500, result);
    }
}
