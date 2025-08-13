package com.ashika.repositories;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ashika.entities.ClientConsentMappingEntity;

@Repository
public class ClientConsentMappingRepositoryImpl
		implements JpaRepository<ClientConsentMappingEntity, Long> {

	@Query(value = "SELECT c" + " FROM ClientConsentMappingEntity" + " WHERE pan = :pan " + "AND run_type = : runType "
			+ "AND state = :state " + "AND data_fetch_status = :dataFetchStatus " + "AND consent_status = :consentStatus "
			+ "ORDER BY lastUpdatedTime desc LIMIT 1 ", nativeQuery = true)
	public ClientConsentMappingEntity getlatestClientConsentObject(@Param("pan") String pan,
			@Param("runType") String runType, 
			@Param("state") String state, @Param("consentStatus") String consentStatus,
			@Param("dataFetchStatus") String dataFetchStatus) {
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
	public List<ClientConsentMappingEntity> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClientConsentMappingEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ClientConsentMappingEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ClientConsentMappingEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
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

	@Override
	public List<ClientConsentMappingEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ClientConsentMappingEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClientConsentMappingEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends ClientConsentMappingEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClientConsentMappingEntity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends ClientConsentMappingEntity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends ClientConsentMappingEntity, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends ClientConsentMappingEntity> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClientConsentMappingEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<ClientConsentMappingEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientConsentMappingEntity getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientConsentMappingEntity getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientConsentMappingEntity getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClientConsentMappingEntity> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClientConsentMappingEntity> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


}
