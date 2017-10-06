package com.ttn.repository;

import org.springframework.data.repository.CrudRepository;

import com.ttn.entity.Project;

public interface ProjectRepository extends CrudRepository<Project,Integer>{

}
