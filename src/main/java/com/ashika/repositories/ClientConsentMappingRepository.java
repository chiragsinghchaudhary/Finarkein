package com.ashika.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashika.model.entities.ClientConsentMappingEntity;


public interface ClientConsentMappingRepository extends JpaRepository<ClientConsentMappingEntity, Long>  {
	
	public Optional<ClientConsentMappingEntity> findByRequestId(String requestId);
	
	public ClientConsentMappingEntity findByRunTypeAndConsentHandle(String runType, String consentHandle);
	
}
