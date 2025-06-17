package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.model.Notification;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByUserId(int userId);
    List<Notification> findBySellerId(int sellerId);
}
