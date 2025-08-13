package com.ashika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.ClientConsentMappingHistEntity;
import com.ashika.entities.ClientConsentMappingHistId;

@Repository
public interface ClientConsentMappingHistRepository extends JpaRepository<ClientConsentMappingHistEntity, ClientConsentMappingHistId> {

}
