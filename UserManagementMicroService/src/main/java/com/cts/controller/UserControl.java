package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Users;
import com.cts.service.UserService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/auctionUserManagement")
@NoArgsConstructor
public class UserControl {

	@Autowired
	UserService service;

	@PostMapping("/save")
	public String addUser(@RequestBody Users user) {
		return service.addUser(user);
	}

	@PutMapping("/update")
	public String updateUser(@RequestBody Users user) {
		return service.updateUser(user);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int userId) {
		return service.deleteUser(userId);
	}

	@GetMapping("/viewAll")
	public List<Users> viewAllUsers() {
		return service.viewAllUsers();
	}

	@GetMapping("/getById/{id}")
	public Optional<Users> getById(@PathVariable("id") int userId) {
		return service.getById(userId);
	}
}
