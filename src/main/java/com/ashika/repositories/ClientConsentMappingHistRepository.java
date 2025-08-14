package com.ashika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.ClientConsentMappingHistEntity;

@Repository
public interface ClientConsentMappingHistRepository extends JpaRepository<ClientConsentMappingHistEntity, Long> {

}
