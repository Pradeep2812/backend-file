package com.SelfDefenseHub.selfdefenseHub.service;

import com.SelfDefenseHub.selfdefenseHub.dto.ProgressDetails;
import com.SelfDefenseHub.selfdefenseHub.dto.SelfDefenseDetails;
import com.SelfDefenseHub.selfdefenseHub.dto.SelfDefenseTutorials;
import com.SelfDefenseHub.selfdefenseHub.entity.ProgressTrackerEntity;
import com.SelfDefenseHub.selfdefenseHub.entity.SelfDefenseTutorialEntity;
import com.SelfDefenseHub.selfdefenseHub.repository.ProgressTrackerRepository;
import com.SelfDefenseHub.selfdefenseHub.repository.SelfDefenseTutorialRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SelfDefenseService {
    @Autowired
    SelfDefenseTutorialRepository selfDefenseTutorialRepository;

    @Autowired
    ProgressTrackerRepository progressTrackerRepository;

    public void AddTutorails(SelfDefenseDetails selfDefenseDetails){
        ObjectMapper mapper = new ObjectMapper();
        SelfDefenseTutorialEntity selfDefenseTutorialEntity = mapper.convertValue(selfDefenseDetails , SelfDefenseTutorialEntity.class);
        selfDefenseTutorialRepository.save(selfDefenseTutorialEntity);
    }

    public SelfDefenseTutorials findAllTutorials(){
        List<SelfDefenseTutorialEntity> selfDefenseTutorialdList = selfDefenseTutorialRepository.findAll();
        SelfDefenseTutorials selfDefenseTutorials = new SelfDefenseTutorials();

        List<SelfDefenseDetails> tutorials = selfDefenseTutorialdList.stream()
                .map(details -> new SelfDefenseDetails(details.getId(), details.getUrl(), details.getTutorialName(), details.getCategory()))
                .collect(Collectors.toList());
        selfDefenseTutorials.setSelfDefenseDetails(tutorials);
        return selfDefenseTutorials;
    }

    public void addProgressDetails(ProgressDetails progressDetails){
        progressTrackerRepository.addUpdateProgress(String.valueOf(progressDetails.getUserId()),
                String.valueOf(progressDetails.getPercentage()), progressDetails.getCategory());
    }

    public List<ProgressTrackerEntity> fetchProgressDetailsForUser(String userId){
        List<ProgressTrackerEntity> progressTrackerEntityList = progressTrackerRepository.fetchAllforUser(userId);
        return progressTrackerEntityList;
    }
}