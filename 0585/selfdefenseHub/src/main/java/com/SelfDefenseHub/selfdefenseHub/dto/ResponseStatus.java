package com.SelfDefenseHub.selfdefenseHub.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatus {

    private int code;
    private boolean success;
    private String message;
    private Object data;
}
