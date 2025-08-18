package com.ashika.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.MutualFundsSummaryEntity;

@Repository
public interface MFSummaryRepository extends JpaRepository<MutualFundsSummaryEntity, Long> {
	
	public List<MutualFundsSummaryEntity> findAllByPan(String pan);
	
	public void deleteAllByPan(String pan);
}
