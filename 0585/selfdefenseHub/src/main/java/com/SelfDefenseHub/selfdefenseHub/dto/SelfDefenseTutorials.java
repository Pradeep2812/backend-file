package com.SelfDefenseHub.selfdefenseHub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelfDefenseTutorials {
    List<SelfDefenseDetails> selfDefenseDetails;
}