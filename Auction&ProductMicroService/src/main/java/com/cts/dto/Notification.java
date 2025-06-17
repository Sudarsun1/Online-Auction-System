package com.cts.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notification {

	private int userId;
	private int sellerId;
	private int auctionId;
	private LocalDateTime time;
	private String message;
}
