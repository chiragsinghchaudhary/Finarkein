package com.ashika.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.DepositTransactionEntity;

@Repository
public interface DepositTransactionRepository extends JpaRepository<DepositTransactionEntity, Long> {
	
	public List<DepositTransactionEntity> findAllByPan(String pan);
	
	public void deleteAllByPan(String pan);

}
