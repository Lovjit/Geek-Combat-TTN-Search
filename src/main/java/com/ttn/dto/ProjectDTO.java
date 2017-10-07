package com.ttn.dto;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDTO {
	
	private Long id;
	
	private String name;
	
	private String countryName;
	
	private String city;
	
	private Long companyId;
	
	private Long applicationTypeId;
	
	private Long engagementTypeId;
	
	private List<Long> technologiesId;
	
	private String projectDescription;
	
    private Calendar startTime;
	
    private Calendar estimatedEndDate;
	
    private String webAppLink;
	
    private String androidAppLink;
	
    private String appleAppLink;
	
    private boolean isTestimonialPresent;
	
    private boolean isReferenceableInPublicDomain;
	
    private String businessHighlightDocUrl;
	
    private String caseStudyDocUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Long> getTechnologiesId() {
		return technologiesId;
	}

	public void setTechnologiesId(List<Long> technologiesId) {
		this.technologiesId = technologiesId;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEstimatedEndDate() {
		return estimatedEndDate;
	}

	public void setEstimatedEndDate(Calendar estimatedEndDate) {
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

	public boolean isTestimonialPresent() {
		return isTestimonialPresent;
	}

	public void setTestimonialPresent(boolean isTestimonialPresent) {
		this.isTestimonialPresent = isTestimonialPresent;
	}

	public boolean isReferenceableInPublicDomain() {
		return isReferenceableInPublicDomain;
	}

	public void setReferenceableInPublicDomain(boolean isReferenceableInPublicDomain) {
		this.isReferenceableInPublicDomain = isReferenceableInPublicDomain;
	}

	public String getBusinessHighlightDocUrl() {
		return businessHighlightDocUrl;
	}

	public void setBusinessHighlightDocUrl(String businessHighlightDocUrl) {
		this.businessHighlightDocUrl = businessHighlightDocUrl;
	}

	public String getCaseStudyDocUrl() {
		return caseStudyDocUrl;
	}

	public void setCaseStudyDocUrl(String caseStudyDocUrl) {
		this.caseStudyDocUrl = caseStudyDocUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getApplicationTypeId() {
		return applicationTypeId;
	}

	public void setApplicationTypeId(Long applicationTypeId) {
		this.applicationTypeId = applicationTypeId;
	}

	public Long getEngagementTypeId() {
		return engagementTypeId;
	}

	public void setEngagementTypeId(Long engagementTypeId) {
		this.engagementTypeId = engagementTypeId;
	}

}
