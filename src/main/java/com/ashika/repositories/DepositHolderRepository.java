package com.ashika.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.DepositHolderEntity;

@Repository
public interface DepositHolderRepository extends JpaRepository<DepositHolderEntity, String> {
	
	public List<DepositHolderEntity> findAllByPan(String pan);
	
}
