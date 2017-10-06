package com.ttn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttn.dto.ProjectDTO;
import com.ttn.entity.Project;
import com.ttn.repository.ProjectRepository;

@Repository
@Transactional
public class ProjectServiceImpl {
	
	@Autowired
	ProjectRepository projectRepository;
	
	public Project save(Project project){
		return projectRepository.save(project);
	}
	
	public Project getById(int id){
		return projectRepository.findOne(id);
	}
	
	public Project update(Project project){
		return projectRepository.save(project);
	}

}
