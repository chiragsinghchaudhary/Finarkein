package com.ashika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.model.entities.MFHolderEntity;

@Repository
public interface MFHolderRepository extends JpaRepository<MFHolderEntity, String> {
		
}
