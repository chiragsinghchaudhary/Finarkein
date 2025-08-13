package com.ashika.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.EquitySummaryEntity;

@Repository
public interface EquitySummaryRepository extends JpaRepository<EquitySummaryEntity, String> {
	public List<EquitySummaryEntity> findAllByPan(String pan);
		
}
