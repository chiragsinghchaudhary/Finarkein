package com.ashika.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.EquitiesSummaryEntity;

@Repository
public interface EquitySummaryRepository extends JpaRepository<EquitiesSummaryEntity, Long> {
	
	public List<EquitiesSummaryEntity> findAllByPan(String pan);
	
	public void deleteAllByPan(String pan);
		
}
