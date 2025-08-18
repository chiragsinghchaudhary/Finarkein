package com.ashika.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.EquitiesHolderEntity;

@Repository
public interface EquityHolderRepository extends JpaRepository<EquitiesHolderEntity, Long> {
	
	public List<EquitiesHolderEntity> findAllByPan(String pan);
	
	public void deleteAllByPan(String pan);
}
