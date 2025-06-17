package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cts.model.Users;
import com.cts.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	UserRepository repository;
	
	@Override
	public String addUser(Users user) {
		repository.save(user);
		return "User Details are successfully saved";
	}

	@Override
	public String updateUser(Users user) {
		repository.save(user);
		return "Updated Successfully";
	}

	@Override
	public String deleteUser(int userId) {
		repository.deleteById(userId);
		return "Deleted the User with userId "+userId+" successfully";
	}

	@Override
	public List<Users> viewAllUsers() {
		return repository.findAll();
	}

	@Override
	public Optional<Users> getById(int userId) {
		return repository.findById(userId);
	}

}
