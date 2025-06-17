package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.InvalidIdException;
import com.cts.model.Auction;
import com.cts.model.Product;
import com.cts.service.ProductService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/auctionProduct")
@NoArgsConstructor
public class ProductControl {

	@Autowired
	ProductService service;
	
//	@PostMapping("/save")
//	public String saveProduct(@RequestBody Product product) {
//	return service.saveProduct(product);
//	}

	@PostMapping("/save")
	public String saveProduct(@RequestBody Product product) {
	    return service.saveProduct(product);
	}
	
	@GetMapping("/fetchAllAuctionProducts")
	public List<Auction> viewAllProductsinAuction(){
		return service.viewAllProductsinAuction();
	}
	
	@GetMapping("/fetchAll")
	public List<Product> viewEveryProducts(){
		return service.viewEveryProducts();
	}
	
	@GetMapping("/fetchById/{id}")
	public Optional<Product> getAnyProductById(@PathVariable("id") int productId) throws InvalidIdException{
		return service.getAnyProductById(productId);
	}
	
	@GetMapping("/fetchAuctionProductByProductId/{id}")
	public Optional<Auction> getAuctionProductsByProductId(@PathVariable("id") int productId){
		return service.getAuctionProductByProductId(productId);
	}

	@GetMapping("/fetchAuctionProductByCategory/{category}")
	public List<Auction> fetchByCategoryInAuction(@PathVariable("category") String productCategory){
		return service.fetchByCategoryInAuction(productCategory);
	}

	@GetMapping("/fetchAuctionProductByPrice/{min}/{max}")
	public List<Auction> fetchByPriceInAuction(@PathVariable("min") int minPrice, @PathVariable("max") int maxPrice ){
		return service.fetchByPriceInAuction(minPrice, maxPrice);
	}

	@PutMapping("/update")
	public String updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@GetMapping("/fetchByTimeLeft/{time}")
	public List<Auction> fetchByMinimumTimeLeftInMins(@PathVariable("time") int timeLeftInHrs){
		return service.fetchByMinimumTimeLeftInMins(timeLeftInHrs);
	}
	
	@PutMapping("/startAuction/{id}")
	public String startAuction(@PathVariable("id") int productId) {
		return service.startAuction(productId);
	}
	
	@GetMapping("/fetchAuctionProductByAuctionId/{id}")
	public Optional<Auction> getAuctionProductsByAuctionId(@PathVariable("id") int productId) throws InvalidIdException{
		return service.getAuctionProductByAuctionId(productId);
		}
		
	@GetMapping("/fetchBiddingAmountByAuctionId/{id}")
	public int getStartingBidAmount(@PathVariable("id") int auctionId) {
			return service.getStartingBidAmount(auctionId);
		}
	
	@GetMapping("/fetchProductBySellerId/{id}")
	public List<Product> getProductBySellerId(@PathVariable("id") int sellerId) throws InvalidIdException {
		return service.getProductBySellerId(sellerId);
	}
}
