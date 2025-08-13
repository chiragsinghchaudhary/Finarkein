package com.ashika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.MFSummaryEntity;

@Repository
public interface MFSummaryRepository extends JpaRepository<MFSummaryEntity, String> {
		
}
