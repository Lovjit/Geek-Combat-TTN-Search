package com.ttn.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttn.domain.ApplicationType;
import com.ttn.domain.Company;
import com.ttn.domain.CompanyType;
import com.ttn.domain.EngagementType;
import com.ttn.domain.IndustryType;
import com.ttn.domain.Project;
import com.ttn.domain.Technology;
import com.ttn.dto.ProjectDTO;
import com.ttn.repository.ApplicationTypeRepository;
import com.ttn.repository.CompanyRepository;
import com.ttn.repository.CompanyTypeRepository;
import com.ttn.repository.EngagementTypeRepository;
import com.ttn.repository.IndustryTypeRepository;
import com.ttn.repository.ProjectRepository;
import com.ttn.repository.TechnologyRepository;

@Repository
@Transactional
public class ProjectServiceImpl {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	ApplicationTypeRepository applicationTypeRepository;
	
	@Autowired
	EngagementTypeRepository engagementTypeRepository;
	
	@Autowired
	TechnologyRepository technologyRepository;
	
	public Project save(Map<String,Object> projectDataMap){
		ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
		ProjectDTO projectDTO = mapper.convertValue(projectDataMap, ProjectDTO.class);
		Long startTimeInMillis = (Long) projectDataMap.get("startTime");
		Long estimatedEndTimeInMillis = (Long) projectDataMap.get("estimatedEndTime");
		
		Calendar startTimeCal = Calendar.getInstance();
		startTimeCal.setTimeInMillis(startTimeInMillis);
		projectDTO.setStartTime(startTimeCal);
		
		Calendar estimatedEndTimeCal = Calendar.getInstance();
		estimatedEndTimeCal.setTimeInMillis(estimatedEndTimeInMillis);
		projectDTO.setEstimatedEndDate(estimatedEndTimeCal);
		
		Long companyId = projectDTO.getCompanyId();
		Long applicationTypeId = projectDTO.getApplicationTypeId();
		Long engagementTypeId = projectDTO.getEngagementTypeId();
		List<Long> technologiesId = projectDTO.getTechnologiesId();
		
		Company company = companyRepository.findOne(companyId);
		List<Technology> technologies = (List<Technology>) technologyRepository.findAll(technologiesId);
		ApplicationType applicationType = applicationTypeRepository.findOne(applicationTypeId);
		EngagementType engagementType = engagementTypeRepository.findOne(engagementTypeId);
		
		
		Project project = mapper.convertValue(projectDTO, Project.class);
		project.setCompany(company);
		project.setTechnologies(technologies);
		project.setApplicationType(applicationType);
		project.setEngagementType(engagementType);
		
		return projectRepository.save(project);
	}
	
	public Project getById(long id){
		return projectRepository.findOne(id);
	}
	
	public Project update(Project project){
		return projectRepository.save(project);
	}

}
