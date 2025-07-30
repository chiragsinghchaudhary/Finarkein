package com.ashika.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ashika.model.entity.ClientConsentMappingHistEntity;

public record ClientConsentMappingHistDTO(
        String clientCode,
        String pan,
        String state,
        String consentStatus,
        String dataFetchStatus,
        LocalDateTime lastUpdatedTime,
        LocalDate dob,
        String email,
        String requestId,
        String consentHandle
) {

    // Convert DTO to Entity
    public ClientConsentMappingHistEntity toEntity() {
        ClientConsentMappingHistEntity entity = new ClientConsentMappingHistEntity();
        entity.setClientCode(clientCode);
        entity.setPan(pan);
        entity.setState(state);
        entity.setConsentStatus(consentStatus);
        entity.setDataFetchStatus(dataFetchStatus);
        entity.setLastUpdatedTime(lastUpdatedTime);
        entity.setDob(dob);
        entity.setEmail(email);
        entity.setRequestId(requestId);
        entity.setConsentHandle(consentHandle);
        return entity;
    }

    // Optional: Convert Entity to DTO
    public static ClientConsentMappingHistDTO fromEntity(ClientConsentMappingHistEntity entity) {
        return new ClientConsentMappingHistDTO(
                entity.getClientCode(),
                entity.getPan(),
                entity.getState(),
                entity.getConsentStatus(),
                entity.getDataFetchStatus(),
                entity.getLastUpdatedTime(),
                entity.getDob(),
                entity.getEmail(),
                entity.getRequestId(),
                entity.getConsentHandle()
        );
    }
}

