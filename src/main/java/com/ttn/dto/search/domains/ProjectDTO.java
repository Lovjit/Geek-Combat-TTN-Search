package com.ttn.dto.search.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ttn.domain.Project;
import com.ttn.domain.Technology;
import com.ttn.dto.GenericCO;

public class ProjectDTO implements GenericCO<Long> {

	private Long id;

	private String name;

	private CompanyDTO company;

	private String applicationType;

	private String engagementType;

	private List<TechnologyDTO> technologies;

	private String description;

	private Date startTime;

	private Date estimatedEndDate;

	private String webAppLink;

	private String androidAppLink;

	private String appleAppLink;

	private String caseStudyDocUrl;

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

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getEngagementType() {
		return engagementType;
	}

	public void setEngagementType(String engagementType) {
		this.engagementType = engagementType;
	}

	public List<TechnologyDTO> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<TechnologyDTO> technologies) {
		this.technologies = technologies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEstimatedEndDate() {
		return estimatedEndDate;
	}

	public void setEstimatedEndDate(Date estimatedEndDate) {
		this.estimatedEndDate = estimatedEndDate;
	}

	public String getWebAppLink() {
		return webAppLink;
	}

	public void setWebAppLink(String webAppLink) {
		this.webAppLink = webAppLink;
	}

	public String getAndroidAppLink() {
		return androidAppLink;
	}

	public void setAndroidAppLink(String androidAppLink) {
		this.androidAppLink = androidAppLink;
	}

	public String getAppleAppLink() {
		return appleAppLink;
	}

	public void setAppleAppLink(String appleAppLink) {
		this.appleAppLink = appleAppLink;
	}

	public String getCaseStudyDocUrl() {
		return caseStudyDocUrl;
	}

	public void setCaseStudyDocUrl(String caseStudyDocUrl) {
		this.caseStudyDocUrl = caseStudyDocUrl;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void update(Project project) {
		this.setId(project.getId());
		this.setDescription(project.getProjectDescription());

		if (project.getTechnologies() != null) {
			this.setTechnologies(new ArrayList<>());
			for (Technology technology : project.getTechnologies()) {
				TechnologyDTO technologyDTO = new TechnologyDTO();
				technologyDTO.setId(technology.getId());
				technologyDTO.setName(technology.getName());
				technologyDTO.setType(technology.getTechnologyType().getName());
				this.getTechnologies().add(technologyDTO);
			}
		}

	}

}
