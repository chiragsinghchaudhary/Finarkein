package com.ashika.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.EquityTransactionEntity;

@Repository
public interface EquityTransactionRepository extends JpaRepository<EquityTransactionEntity, Long> {
	
	public List<EquityTransactionEntity> findAllByPan(String pan);
	
	public void deleteAllByPan(String pan);
			
}
