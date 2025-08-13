package com.ashika.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.EquityHolderEntity;

@Repository
public interface EquityHolderRepository extends JpaRepository<EquityHolderEntity, String> {
	public List<EquityHolderEntity> findAllByPan(String pan);
		
}
