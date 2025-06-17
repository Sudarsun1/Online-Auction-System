package com.cts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_info")
public class Users {

	@Id
	@GeneratedValue
	private int userId;
	private String gmailId;
	private String role;
	private String password;
	private String contactNumber;
}
