package com.ashika.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashika.entities.MFSummaryEntity;

@Repository
public interface MFSummaryRepository extends JpaRepository<MFSummaryEntity, String> {
	public List<MFSummaryEntity> findAllByPan(String pan);
}
