package com.SelfDefenseHub.selfdefenseHub.service;

import com.SelfDefenseHub.selfdefenseHub.entity.Notification;
import com.SelfDefenseHub.selfdefenseHub.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
    
    public void sendNotification(Notification notification) {
        
        notificationRepository.save(notification);

    }

    public List<Notification> getNotifications() {
        return notificationRepository.findAllByStatus("U");
    }
}
