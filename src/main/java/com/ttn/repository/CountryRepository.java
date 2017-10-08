package com.ttn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttn.domain.Country;
import com.ttn.domain.Project;

@Repository
@Transactional
public interface CountryRepository extends CrudRepository<Country, Long> {


}
