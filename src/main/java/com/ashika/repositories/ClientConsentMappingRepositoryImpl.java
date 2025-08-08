package com.ashika.repositories;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashika.model.entities.ClientConsentMappingEntity;
import com.ashika.model.entities.ClientConsentMappingId;


@Repository
public class ClientConsentMappingRepositoryImpl implements CrudRepository<ClientConsentMappingEntity, ClientConsentMappingId> {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientConsentMappingRepositoryImpl.class);

	public ClientConsentMappingRepositoryImpl() {
		logger.debug("ClientConsentMappingRepository initialized");
	}
	
	@Modifying
	@Query("INSERT into ClientConsentMappingEntity (pan, requestId, clientCode, runType, dob, consentHandle, lastUpdatedTime) VALUES(:pan , :requestId, :clientCode, :runType, :dob, :consentHandle, :lastUpdatedTime)" )
	@Transactional
	public
		ClientConsentMappingEntity insert(@Param("pan") String pan, @Param("requestId") String requestId, 
				@Param("clientCode") String clientCode, @Param("runType") String runType, @Param("dob") LocalDate dob, @Param("consentHandle") String consentHandle, @Param("lastUpdatedTime") LocalDateTime lastUpdatedTime) {
		return null;
	}

	@Query("SELECT c"
			+ " FROM ClientConsentMappingEntity" +
		       "WHERE pan = :pan " +
		       "AND runType = : runType "  +
		       "AND state = :success " +
		       "AND dataFetchStatus = :active " +
		       "AND consentStatus = :success " + 
		       "ORDER BY lastUpdatedTime desc LIMIT 1 ")
	public
		ClientConsentMappingEntity getlatestClientConsentObject(@Param("pan") String pan, @Param("runType") String runType, @Param("success") String success, @Param("active") String active) {
		return null;
	}
	
	@Query("SELECT c FROM ClientConsentMappingEntity "
			+ "WHERE requestId = : requestId ")
	public
	ClientConsentMappingEntity getByRequestId(@Param("requestId") String requestId) {
		return null;
	}
	
	@Query("SELECT c FROM ClientConsentMappingEntity "
			+ "WHERE runType = : runType "  +
			" AND consentHandle = : consentHandle ")
	public
	ClientConsentMappingEntity getByConsentHandle(@Param("runType") String runType, @Param("consentHandle") String consentHandle) {
	return null;
	}
	
	@Query("UPDATE ClientConsentMappingEntity "
			+ "SET state = :state, dataFetchStatus = :dataFetchStatus ,"
			+ "consentStatus = : consentStatus"
			+ "requestId = : requestId" +
		       "WHERE pan = : pan ")
		List<ClientConsentMappingEntity> updateNewRunFetch(@Param("state") String state,
				@Param("dataFetchStatus") String dataFetchStatus,
				@Param("consentStatus") String consentStatus,
				@Param("requestId") String requestId,
				@Param("pan") String pan) {
		return null;
	}

	@Query("UPDATE ClientConsentMappingEntity "
			+ "SET state = :state, dataFetchStatus = :dataFetchStatus ,"
			+ "consentStatus = : consentStatus" +
		       "WHERE requestId = : requestId ")
	public
		List<ClientConsentMappingEntity> updateStatus(@Param("state") String state,
				@Param("dataFetchStatus") String dataFetchStatus,
				@Param("consentStatus") String consentStatus,
				@Param("requestId") String requestId) {
		return null;
	}

	@Override
	public <S extends ClientConsentMappingEntity> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientConsentMappingEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientConsentMappingEntity> findAllById(Iterable<ClientConsentMappingId> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClientConsentMappingEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ClientConsentMappingEntity> findById(ClientConsentMappingId id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(ClientConsentMappingId id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(ClientConsentMappingId id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ClientConsentMappingEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends ClientConsentMappingId> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends ClientConsentMappingEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}	
}

