package com.ashika.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashika.model.entities.ClientConsentMappingEntity;
import com.ashika.model.entities.ClientConsentMappingId;


public interface ClientConsentMappingRepository extends JpaRepository<ClientConsentMappingEntity, ClientConsentMappingId>  {

	public Optional<ClientConsentMappingEntity> findByClientMappingId_Pan(String pan);
	
	public Optional<ClientConsentMappingEntity> findByClientMappingId_RequestId(String requestId);
	
	public ClientConsentMappingEntity findByRunTypeAndConsentHandle(String runType, String consentHandle);
	
}
