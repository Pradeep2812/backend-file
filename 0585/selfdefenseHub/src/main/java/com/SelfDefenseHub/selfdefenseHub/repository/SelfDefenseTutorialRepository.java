package com.SelfDefenseHub.selfdefenseHub.repository;

import com.SelfDefenseHub.selfdefenseHub.entity.SelfDefenseTutorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfDefenseTutorialRepository extends JpaRepository<SelfDefenseTutorialEntity, Long> {

}