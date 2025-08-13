package com.ashika.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.MFTransactionEntity;

@Repository
public interface MFTransactionRepository extends JpaRepository<MFTransactionEntity, String> {
	public List<MFTransactionEntity> findAllByPan(String pan);
}
