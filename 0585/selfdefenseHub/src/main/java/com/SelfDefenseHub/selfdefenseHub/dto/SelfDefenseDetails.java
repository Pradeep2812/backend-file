package com.SelfDefenseHub.selfdefenseHub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelfDefenseDetails {
    private long id;
    private String tutorialName;
    private String category;
    private String url;
}
