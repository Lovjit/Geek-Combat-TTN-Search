package com.ttn.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttn.domain.City;
import com.ttn.domain.Country;
import com.ttn.domain.Project;
import com.ttn.domain.State;

@Repository
@Transactional
public interface CityRepository extends CrudRepository<City, Long> {

	List<City> findByState(State state);

}
