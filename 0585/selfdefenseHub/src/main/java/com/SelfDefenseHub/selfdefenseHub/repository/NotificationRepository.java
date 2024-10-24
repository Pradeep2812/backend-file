package com.SelfDefenseHub.selfdefenseHub.repository;


import com.SelfDefenseHub.selfdefenseHub.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByStatus(String status);
    
}
