package com.ashika.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashika.entities.ClientConsentMappingEntity;


public interface ClientConsentMappingRepository extends JpaRepository<ClientConsentMappingEntity, Long>  {
	
	public Optional<ClientConsentMappingEntity> findByRequestId(String requestId);
	
	public ClientConsentMappingEntity findTopByPanAndRunTypeAndStateAndConsentStatusAndDataFetchStatusOrderByLastUpdatedTimeDesc(String pan, String runType, String state, String consentStatus, String dataFetchStatus);
	
	public ClientConsentMappingEntity findByRunTypeAndConsentHandle(String runType, String consentHandle);
	
}
