package com.ashika.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.model.entities.DepositTransactionEntity;

@Repository
public interface DepositTransactionRepository extends JpaRepository<DepositTransactionEntity, String> {


}
