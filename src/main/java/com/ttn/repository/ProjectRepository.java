package com.ttn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ttn.domain.Project;

@Repository
@Transactional(readOnly = true)
public interface ProjectRepository extends CrudRepository<Project, Long> {


}
