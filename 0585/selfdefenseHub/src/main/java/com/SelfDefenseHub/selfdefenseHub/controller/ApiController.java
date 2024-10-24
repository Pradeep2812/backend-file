package com.SelfDefenseHub.selfdefenseHub.controller;

import com.SelfDefenseHub.selfdefenseHub.dto.ProgressDetails;
import com.SelfDefenseHub.selfdefenseHub.dto.SelfDefenseDetails;
import com.SelfDefenseHub.selfdefenseHub.dto.SelfDefenseTutorials;
import com.SelfDefenseHub.selfdefenseHub.entity.ProgressTrackerEntity;
import com.SelfDefenseHub.selfdefenseHub.service.SelfDefenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/selfDefenseHub")
public class ApiController {

    @Autowired
    SelfDefenseService selfDefenseService;

    @PostMapping(value = "/addTutorial" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void AddTutorial(@RequestBody SelfDefenseDetails selfDefenseDetails){
        selfDefenseService.AddTutorails(selfDefenseDetails);
    }

    @GetMapping(value = "/fetchAllTutorials" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SelfDefenseTutorials findAllTutorials(){
        return selfDefenseService.findAllTutorials();
    }

    @PostMapping(value = "/trackProgress" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addProgress(@RequestBody ProgressDetails progressDetails){
        selfDefenseService.addProgressDetails(progressDetails);
    }

    @GetMapping(value = "/fetchProgress" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProgressTrackerEntity> fetchProgress(@RequestParam String userId){
        return selfDefenseService.fetchProgressDetailsForUser(userId);
    }
}