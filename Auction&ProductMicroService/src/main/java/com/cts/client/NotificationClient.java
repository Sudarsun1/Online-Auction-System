package com.cts.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.dto.Notification;

@FeignClient(name = "Notification", url = "http://localhost:4034/auctionRating")
public interface NotificationClient {
    @PostMapping("/create")
    public Notification saveNotification(@RequestBody Notification notification);
}
