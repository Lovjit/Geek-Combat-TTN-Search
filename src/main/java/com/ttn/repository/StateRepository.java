package com.ttn.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttn.domain.Country;
import com.ttn.domain.Project;
import com.ttn.domain.State;

@Repository
@Transactional
public interface StateRepository extends CrudRepository<State, Long> {

	List<State> findByCountry(Country country);

}
