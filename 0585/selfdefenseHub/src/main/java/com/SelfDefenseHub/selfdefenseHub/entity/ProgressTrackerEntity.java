package com.SelfDefenseHub.selfdefenseHub.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "progress_tracker")
public class ProgressTrackerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "percentage")
    private long percentage;

    @Column(name = "notes")
    private String notes;

    @Column(name = "category")
    private String category;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
