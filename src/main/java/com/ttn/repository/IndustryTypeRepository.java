package com.ttn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttn.domain.IndustryType;

@Repository
@Transactional(readOnly = true)
public interface IndustryTypeRepository extends JpaRepository<IndustryType, Long> {

	List<IndustryType> findAll(Iterable<Long> idList);

}
