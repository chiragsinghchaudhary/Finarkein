package com.ashika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.model.entities.EquityHolderEntity;

@Repository
public interface EquityHolderRepository extends JpaRepository<EquityHolderEntity, String> {
		
}
