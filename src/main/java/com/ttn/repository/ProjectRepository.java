package com.ttn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttn.domain.Project;

@Repository
@Transactional(readOnly = true)
public interface ProjectRepository extends JpaRepository<Project, Long> {

	List<Project> findAll(Iterable<Long> idList);

}
