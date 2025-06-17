package com.cts.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Notification {

	@Id
	@GeneratedValue
	private int messageId;
	private int userId;
	private int sellerId;
	private int auctionId;
	private LocalDateTime time;
	private String message;
}
