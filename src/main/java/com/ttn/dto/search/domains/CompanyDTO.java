package com.ttn.dto.search.domains;

import java.util.ArrayList;
import java.util.List;

import com.ttn.domain.Company;
import com.ttn.domain.Project;
import com.ttn.domain.Technology;
import com.ttn.dto.GenericCO;

public class CompanyDTO implements GenericCO<Long> {

	private Long id;

	private String name;

	private String location;

	private String description;

	private List<ProjectDTO> projects;

	private String companyType;

	private String industryType;

	private String testimonial;

	private Boolean referenceInPublicDomain;

	private String highlightsLink;

	private String contentType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getTestimonial() {
		return testimonial;
	}

	public void setTestimonial(String testimonial) {
		this.testimonial = testimonial;
	}

	public Boolean getReferenceInPublicDomain() {
		return referenceInPublicDomain;
	}

	public void setReferenceInPublicDomain(Boolean referenceInPublicDomain) {
		this.referenceInPublicDomain = referenceInPublicDomain;
	}

	public String getHighlightsLink() {
		return highlightsLink;
	}

	public void setHighlightsLink(String highlightsLink) {
		this.highlightsLink = highlightsLink;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public List<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}

	public void update(Company company) {
		this.setId(company.getId());
		this.setDescription(company.getCompanyDescription());
		this.setCompanyType(company.getCompanyType().getName());
		this.setIndustryType(company.getIndustryType().getName());
		this.setHighlightsLink(company.getHighlightsLink());
		this.setLocation(company.getLocation());
		this.setName(company.getName());
		this.setReferenceInPublicDomain(company.getReferenceInPublicDomain());
		this.setTestimonial(company.getTestimonial());

		if (company.getProjects() != null) {
			this.setProjects(new ArrayList<>());

			for (Project project : company.getProjects()) {
				ProjectDTO dto = new ProjectDTO();
				dto.setId(project.getId());
				dto.setName(project.getName());
				dto.update(project);
				this.getProjects().add(dto);
				if (project.getTechnologies() != null) {
					dto.setTechnologies(new ArrayList<>());
					for (Technology technology : project.getTechnologies()) {
						TechnologyDTO technologyDTO = new TechnologyDTO();
						technologyDTO.setId(technology.getId());
						technologyDTO.setName(technology.getName());
						technologyDTO.setType(technology.getTechnologyType().getName());
						dto.getTechnologies().add(technologyDTO);
					}
				}
			}
		}
	}
}
