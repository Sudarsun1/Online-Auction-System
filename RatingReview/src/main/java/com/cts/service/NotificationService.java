package com.cts.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.cts.model.Notification;
import com.cts.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(int id) {
        return notificationRepository.findById(id);
    }

    public List<Notification> getNotificationsByUserId(int userId) {
        return notificationRepository.findByUserId(userId);
    }

    public List<Notification> getNotificationsBySellerId(int sellerId) {
        return notificationRepository.findBySellerId(sellerId);
    }

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void deleteNotification(int id) {
        notificationRepository.deleteById(id);
    }
}
