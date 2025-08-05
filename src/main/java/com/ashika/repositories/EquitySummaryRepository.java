package com.ashika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.model.entities.EquitySummaryEntity;

@Repository
public interface EquitySummaryRepository extends JpaRepository<EquitySummaryEntity, String> {

		
}
