package com.ttn.dto;

import java.util.List;

import com.ttn.domain.ApplicationType;
import com.ttn.domain.Country;
import com.ttn.domain.EngagementType;
import com.ttn.domain.Technology;

public class ProjectDropDownDTO {
	
	List<ApplicationType> applicationTypes;
	
	List<EngagementType> engagementTypes;
	
	List<Technology> technologies;
	
	List<Country> countries;

	public List<ApplicationType> getApplicationTypes() {
		return applicationTypes;
	}

	public void setApplicationTypes(List<ApplicationType> applicationTypes) {
		this.applicationTypes = applicationTypes;
	}

	public List<EngagementType> getEngagementTypes() {
		return engagementTypes;
	}

	public void setEngagementTypes(List<EngagementType> engagementTypes) {
		this.engagementTypes = engagementTypes;
	}

	public List<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	

}
