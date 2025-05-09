package com.cts.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.client.BiddingClient;
import com.cts.dto.Bidding;
import com.cts.model.Auction;
import com.cts.model.Product;
import com.cts.repository.AuctionRepository;
import com.cts.repository.ProductRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;

	@Autowired
	AuctionRepository auctionRepo;
	
	@Autowired
	BiddingClient bidClient;

	@Override
	public String saveProduct(Product product) {
		productRepo.save(product);
		return "Product Saved Successfully";
	}

	@Override
	public List<Auction> viewAllProductsinAuction() {
		return auctionRepo.findAll();
	}

	@Override
	public List<Auction> fetchByCategoryInAuction(String productCategory) {

		return auctionRepo.fetchByCategoryInAuction(productCategory);
	}

	@Override
	public List<Auction> fetchByPriceInAuction(int minPrice, int maxPrice) {
		return auctionRepo.fetchByPriceInAuction(minPrice, maxPrice);
	}

	@Override
	public String updateProduct(Product product) {
		return "Product Updated Successfully";
	}

	@Override
	public List<Auction> fetchByMinimumTimeLeftInMins(int timeLeftInMins) {
		LocalDateTime now = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(now);
		return auctionRepo.fetchByMinimumTimeLeftInMins(timeLeftInMins, timestamp.toLocalDateTime());
	}

	@Override
	public List<Product> viewEveryProducts() {
		return productRepo.findAll();
	}

	@Override
	public Optional<Product> getAnyProductById(int productId) {
		return productRepo.findById(productId);
	}

	@Override
	public Optional<Auction> getAuctionProductByProductId(int productId) {
		return auctionRepo.findById(productId);
	}
	
	@Override
	public Optional<Auction> getAuctionProductByAuctionId(int auctionId){
		return auctionRepo.findById(auctionId);
	}

	@Override
	public String startAuction(int productId) {
		Optional<Product> prodOptional = productRepo.findById(productId);

	    if (prodOptional.isPresent()) {  // Check if value exists
	    Product product = prodOptional.get();  // Get the actual Product object
	    productRepo.startAuction1(product.getProductId());  // Pass the ID
		Auction auc = new Auction();
		auc.setProductId(product.getProductId());
		auc.setStartTime(LocalDateTime.now());
		auc.setEndTime(product.getEndTime());
		auc.setCurrentBid(product.getInitialBiddingAmount());
		auc.setStatus("Available");
		auc.setProductCategory(product.getProductCategory());
		auc.setProductName(product.getProductName());
		auc.setProductDescription(product.getProductDescription());
		auctionRepo.save(auc);
		return "The Auction is started Successfully";
	    }
	    else {
	    	return "Product Not Found";
	    }
	}

	@Override
	public void endAuction() {
		LocalDateTime now = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(now);
		productRepo.changeStatusToCompletedInProduct(timestamp.toLocalDateTime());
		auctionRepo.changeStatusToCompletedInAuction(timestamp.toLocalDateTime());
		int[] ids = auctionRepo.getCompletedAuctionId();
		if(ids.length != 0) {
		auctionRepo.deleteAuction();
		for(int id:ids) {
		Bidding bid = new Bidding();
		bid = bidClient.findResult(id);
		auctionRepo.updateWinnerInAuction(bid.getWinnerId(),bid.getWinningAmount());
		}
		}
	}

}
