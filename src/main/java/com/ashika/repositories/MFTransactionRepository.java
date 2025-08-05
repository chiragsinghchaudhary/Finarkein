package com.ashika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.model.entities.MFTransactionEntity;

@Repository
public interface MFTransactionRepository extends JpaRepository<MFTransactionEntity, String> {

}
