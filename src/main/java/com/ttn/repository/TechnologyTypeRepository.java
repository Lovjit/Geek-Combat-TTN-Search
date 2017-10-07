package com.ttn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttn.domain.TechnologyType;

@Repository
@Transactional(readOnly = true)
public interface TechnologyTypeRepository extends CrudRepository<TechnologyType, Long> {

}
