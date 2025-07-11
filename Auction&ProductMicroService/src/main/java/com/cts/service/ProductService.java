package com.cts.service;

import java.util.List;
import java.util.Optional;

import com.cts.exception.InvalidIdException;
import com.cts.model.Auction;
import com.cts.model.Product;

public interface ProductService {
	public String saveProduct(Product product);

	public List<Auction> viewAllProductsinAuction();
	
	public List<Product> viewEveryProducts();
	
	public Optional<Product> getAnyProductById(int productId) throws InvalidIdException;
	
	public List<Product> getProductBySellerId(int productId) throws InvalidIdException;
	
	public Optional<Auction> getAuctionProductByProductId(int productId);
	
	public Optional<Auction> getAuctionProductByAuctionId(int auctionId) throws InvalidIdException;

	public List<Auction> fetchByCategoryInAuction(String productCategory);

	public List<Auction> fetchByPriceInAuction(int minPrice, int maxPrice );

	public String updateProduct(Product product);

	public List<Auction> fetchByMinimumTimeLeftInMins(int timeLeftInMins);
	
	public String startAuction(int productId);
	
	public void endAuction();
	
	public int getStartingBidAmount(int auctionId);
	
}
