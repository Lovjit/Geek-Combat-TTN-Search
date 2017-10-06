package com.ttn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttn.domain.CompanyType;

@Repository
@Transactional(readOnly = true)
public interface EngagementTypeRepository extends JpaRepository<CompanyType, Long> {

	List<CompanyType> findAll(Iterable<Long> idList);

}
