package com.SelfDefenseHub.selfdefenseHub.repository;

import com.SelfDefenseHub.selfdefenseHub.entity.ProgressTrackerEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressTrackerRepository extends JpaRepository<ProgressTrackerEntity,Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO progress_tracker (user_id , percentage , category ) VALUES (:userId , :percentage , :category) " +
            "ON DUPLICATE KEY UPDATE percentage = :percentage", nativeQuery = true)
    void addUpdateProgress(String userId, String percentage , String category);

    @Query(value = "SELECT * from progress_tracker where user_id = :userId" , nativeQuery = true)
    List<ProgressTrackerEntity> fetchAllforUser(String userId);
}
