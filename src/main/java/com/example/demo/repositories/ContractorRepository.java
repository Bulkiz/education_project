package com.example.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Contractor;
import com.example.demo.enums.ContractorType;
import com.example.demo.enums.LegalType;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Integer>{

	@Query(value = "select e from Contractor e where " 
			+ "(:id is null or cast( e.id as text ) like concat (cast(:id as text), '%')) and "
			+ "(:code is null or cast( e.code as text ) like concat (cast(:code as text), '%')) and "
			+ "(:name is null or lower(e.name) like concat (cast(:name as text), '%')) and "
			+ "(e.isActive in (:isActive) or :isActive is null) and "
			+ "(:contractorType is null or e.contractorType = :contractorType) and "
			+ "(:legalType is null or e.legalType = :legalType) and "
			+ "(:pin is null or cast( e.pin as text ) like concat (cast(:pin as text), '%'))",
			countQuery = ( "select count(e) from Contractor e where " 
					+ "(:id is null or cast( e.id as text ) like concat (cast(:id as text), '%')) and "
					+ "(:code is null or cast( e.code as text ) like concat (cast(:code as text), '%')) and "
					+ "(:name is null or lower(e.name) like concat (cast(:name as text), '%')) and "
					+ "(e.isActive in (:isActive) or :isActive is null) and "
					+ "(:contractorType is null or e.contractorType = :contractorType) and "
					+ "(:legalType is null or e.legalType = :legalType) and "
					+ "(:pin is null or cast( e.pin as text ) like concat (cast(:pin as text), '%'))"))
	public Page<Contractor> findAllPaged(@Param("id") Integer id,
			@Param("code") String code,
			@Param("name") String name, @Param("isActive") Boolean isActive,
			@Param("contractorType") ContractorType contractorType,
			@Param("legalType") LegalType legalType,
			@Param("pin") String pin,
			Pageable pageable);
	
}


	