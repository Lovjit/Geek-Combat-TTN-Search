package com.ttn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttn.domain.EngagementType;

@Repository
@Transactional(readOnly = true)
public interface EngagementTypeRepository extends CrudRepository<EngagementType, Long> {

}
