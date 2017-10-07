package com.ttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttn.domain.ApplicationType;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface ApplicationTypeRepository extends JpaRepository<ApplicationType, Long> {

	List<ApplicationType> findAll(Iterable<Long> idList);

}
