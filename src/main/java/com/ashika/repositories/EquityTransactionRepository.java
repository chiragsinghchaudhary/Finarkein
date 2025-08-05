package com.ashika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.model.entities.EquityTransactionEntity;

@Repository
public interface EquityTransactionRepository extends JpaRepository<EquityTransactionEntity, String> {

			
}
