package com.SelfDefenseHub.selfdefenseHub.entity;


import com.SelfDefenseHub.selfdefenseHub.utils.DateUtils;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@MappedSuperclass
@Data
public class Base {
    
    private String createdBy;
    private String createdAt;
    private String modifiedBy;
    private String modifiedAt;

    @PrePersist
    public void prePersist() {
        createdAt = modifiedAt = DateUtils.getCurrentDateTime();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedAt = DateUtils.getCurrentDateTime();
    }
}
