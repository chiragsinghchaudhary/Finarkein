package com.ashika.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.model.entities.DepositSummaryEntity;

@Repository
public interface DepositSummaryRepository extends JpaRepository<DepositSummaryEntity, String> {
	
}
