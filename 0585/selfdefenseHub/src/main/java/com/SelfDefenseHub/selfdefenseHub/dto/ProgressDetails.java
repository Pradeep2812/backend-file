package com.SelfDefenseHub.selfdefenseHub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgressDetails {

    @NonNull
    private long userId;

    @NonNull
    private long percentage;

    private String notes;

    @NonNull
    private String category;
}
