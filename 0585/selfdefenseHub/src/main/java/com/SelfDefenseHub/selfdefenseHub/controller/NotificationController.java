package com.SelfDefenseHub.selfdefenseHub.controller;

import com.SelfDefenseHub.selfdefenseHub.entity.Notification;
import com.SelfDefenseHub.selfdefenseHub.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    
    @PostMapping("/send_notification")
    public void sendNotification(@RequestBody Notification notification) {
        notificationService.sendNotification(notification);
    }
    
    @GetMapping("/get_notifications")
    public List<Notification> getNotifications() {
        return notificationService.getNotifications();
    }

}
