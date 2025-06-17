package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

}
