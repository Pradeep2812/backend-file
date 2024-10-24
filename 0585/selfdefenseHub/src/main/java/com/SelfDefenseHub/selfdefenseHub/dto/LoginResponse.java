package com.SelfDefenseHub.selfdefenseHub.dto;

import com.SelfDefenseHub.selfdefenseHub.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String jwtToken;
    private User userDetails;
}
