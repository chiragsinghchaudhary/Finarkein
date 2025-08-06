package com.ashika.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ashika.model.entities.ClientConsentMappingEntity;

	public record ClientConsentMappingDTO(
	        String clientCode,
	        String pan,
	        String runType,
	        String state,
	        String consentStatus,
	        String dataFetchStatus,
	        LocalDate dob,
	        String requestId,
	        String consentHandle
			) 
	{
    // Convert DTO → Entity
    public ClientConsentMappingEntity toEntity() {
        ClientConsentMappingEntity entity = new ClientConsentMappingEntity(this.pan(), this.requestId(), this.clientCode(), 
        		this.runType, this.state(), this.consentStatus(), this.dataFetchStatus(), this.dob(),
        		 this.consentHandle(), LocalDateTime.now());
        return entity;
    }
}
