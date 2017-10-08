package com.ttn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ttn.domain.City;
import com.ttn.domain.Country;
import com.ttn.domain.Project;
import com.ttn.domain.State;
import com.ttn.dto.ProjectDropDownDTO;
import com.ttn.service.CityServiceImpl;
import com.ttn.service.CountryServiceImpl;
import com.ttn.service.ProjectServiceImpl;
import com.ttn.service.StateServiceImpl;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {
	
	@Autowired
	ProjectServiceImpl projectService;
	
	@Autowired
	CountryServiceImpl countryService;
	
	@Autowired
	StateServiceImpl stateServiceImpl;
	
	@Autowired
	CityServiceImpl cityServiceImpl;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Project> saveProject(@RequestBody Map<String,Object> projectDataMap) {
		return projectService.save(projectDataMap);
		//return projectService.save((Map<String,Object>) ( ( (List<Object>) projectDataMap.get("data")).get(0) ) );
		//return null;
    }
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST, consumes = {"multipart/form-data", "image/jpeg", "image/png"})
	public @ResponseBody ResponseEntity<String> update(@RequestParam("file") MultipartFile file) {
		 return null;
	}
	
	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Country>> getAllCountries() {
		return countryService.getAllCountries();
	}
	
	@RequestMapping(value = "/country/{countryId}/state", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<State>> getStatesByCountry(@PathVariable Long countryId) {
		 return stateServiceImpl.getAllStatesByCountry(countryId);
	}
	
	@RequestMapping(value = "/state/{stateId}/city", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<City>> getCitiesByState(@PathVariable Long stateId) {
		 return cityServiceImpl.getAllCitiesByState(stateId);
	}
	
	@RequestMapping(value = "/getDropDownData", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ProjectDropDownDTO> getDropDownData() {
		 return projectService.getDropDownProjectRelatedData();
	}

}
