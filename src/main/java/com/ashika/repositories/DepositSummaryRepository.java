package com.ashika.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.DepositSummaryEntity;

@Repository
public interface DepositSummaryRepository extends JpaRepository<DepositSummaryEntity, String> {
	public List<DepositSummaryEntity> findAllByPan(String pan);

}
