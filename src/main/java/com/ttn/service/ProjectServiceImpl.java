package com.ttn.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttn.domain.ApplicationType;
import com.ttn.domain.City;
import com.ttn.domain.State;
import com.ttn.domain.Company;
import com.ttn.domain.CompanyType;
import com.ttn.domain.Country;
import com.ttn.domain.EngagementType;
import com.ttn.domain.IndustryType;
import com.ttn.domain.Project;
import com.ttn.domain.Technology;
import com.ttn.dto.ProjectDTO;
import com.ttn.dto.ProjectDropDownDTO;
import com.ttn.repository.ApplicationTypeRepository;
import com.ttn.repository.CityRepository;
import com.ttn.repository.CompanyRepository;
import com.ttn.repository.CompanyTypeRepository;
import com.ttn.repository.CountryRepository;
import com.ttn.repository.EngagementTypeRepository;
import com.ttn.repository.IndustryTypeRepository;
import com.ttn.repository.ProjectRepository;
import com.ttn.repository.StateRepository;
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
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	public ResponseEntity<Project> save(Map<String,Object> projectDataMap){
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
		
		Long countryId = projectDTO.getCountryId();
		Long stateId = projectDTO.getStateId();
		Long cityId = projectDTO.getCityId();
		Long companyId = projectDTO.getCompanyId();
		Long applicationTypeId = projectDTO.getApplicationTypeId();
		Long engagementTypeId = projectDTO.getEngagementTypeId();
		List<Long> technologiesId = projectDTO.getTechnologiesId();
		
		Country country  = countryRepository.findOne(countryId);
		State state = stateRepository.findOne(stateId);
		City city = cityRepository.findOne(cityId);
		Company company = companyRepository.findOne(companyId);
		List<Technology> technologies = (List<Technology>) technologyRepository.findAll(technologiesId);
		ApplicationType applicationType = applicationTypeRepository.findOne(applicationTypeId);
		EngagementType engagementType = engagementTypeRepository.findOne(engagementTypeId);
		
		
		Project project = mapper.convertValue(projectDTO, Project.class);
		project.setCompany(company);
		project.setTechnologies(technologies);
		project.setApplicationType(applicationType);
		project.setEngagementType(engagementType);
		project.setCountry(country);
		project.setState(state);
		project.setCity(city);
		
		Project project2 = projectRepository.save(project);
		
		return new ResponseEntity<Project>(project2,HttpStatus.OK);
	}
	
	public Project getById(long id){
		return projectRepository.findOne(id);
	}
	
	public Project update(Project project){
		return projectRepository.save(project);
	}
	
	public ResponseEntity<ProjectDropDownDTO> getDropDownProjectRelatedData(){
		List<ApplicationType> applicationTypes = applicationTypeRepository.findAll();
		List<EngagementType> engagementTypes = (List<EngagementType>) engagementTypeRepository.findAll();
		List<Technology> technologies = (List<Technology>) technologyRepository.findAll();
		List<Country> countries = (List<Country>) countryRepository.findAll();
		ProjectDropDownDTO projectDropDownDTO = new ProjectDropDownDTO();
		projectDropDownDTO.setApplicationTypes(applicationTypes);
		projectDropDownDTO.setCountries(countries);
		projectDropDownDTO.setTechnologies(technologies);
		projectDropDownDTO.setEngagementTypes(engagementTypes);
		return new ResponseEntity<ProjectDropDownDTO>(projectDropDownDTO,HttpStatus.OK);
		//return projectRepository.save(project);
	}

}
