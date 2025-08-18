package com.ashika.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.MutualFundsHolderEntity;

@Repository
public interface MFHolderRepository extends JpaRepository<MutualFundsHolderEntity, Long> {
	
	public List<MutualFundsHolderEntity> findAllByPan(String pan);
	
	public void deleteAllByPan(String pan);
}
