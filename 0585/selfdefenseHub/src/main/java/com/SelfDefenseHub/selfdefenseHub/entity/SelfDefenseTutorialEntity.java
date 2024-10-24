package com.SelfDefenseHub.selfdefenseHub.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "self_defence_tutorials")
public class SelfDefenseTutorialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "tutorial_name")
    private String tutorialName;

    @Column(name = "url")
    private String url;

    @Column(name = "category")
    private String category;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
