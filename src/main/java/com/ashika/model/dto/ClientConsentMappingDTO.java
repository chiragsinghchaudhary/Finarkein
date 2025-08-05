package com.ashika.model.dto;

import java.time.LocalDate;

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
        ClientConsentMappingEntity entity = new ClientConsentMappingEntity();
        entity.setClientCode(this.clientCode());
        entity.setPan(this.pan());
        entity.setPan(this.runType);
        entity.setState(this.state());
        entity.setConsentStatus(this.consentStatus());
        entity.setDataFetchStatus(this.dataFetchStatus());
        entity.setDob(this.dob());
        entity.setRequestId(this.requestId());
        entity.setConsentHandle(this.consentHandle());
        return entity;
    }
}
