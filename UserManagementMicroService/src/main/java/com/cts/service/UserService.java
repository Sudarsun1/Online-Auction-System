package com.cts.service;

import java.util.List;
import java.util.Optional;

import com.cts.model.Users;

public interface UserService {

	public String addUser(Users user);
	
	public String updateUser(Users user);
	
	public String deleteUser(int userId);
	
	public List<Users> viewAllUsers();
	
	public Optional<Users> getById(int userId);
}
