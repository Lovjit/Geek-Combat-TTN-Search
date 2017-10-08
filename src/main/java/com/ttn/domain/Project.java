package com.ttn.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ttn.jdbcCallbacks.Searchable;

@Entity
@Table(name = "project")
@EntityListeners({Searchable.class})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project extends AbstractDomain {

	
	@Column(name="name",nullable=false)
	private String name;
	
	@OneToOne
	private Country country;
	
	@OneToOne
	private State state;
	
	@OneToOne
	private City city;
	
	@ManyToOne
	@JoinColumn
	private Company company;

	@OneToOne(cascade = CascadeType.ALL)
	private ApplicationType applicationType;

	@OneToOne(cascade = CascadeType.ALL)
	private EngagementType engagementType;

	@OneToMany
	private List<Technology> technologies;
	
	@Column(name="project_description",nullable=true)
	private String projectDescription;
	@Column(name = "start_time",nullable=true)
    private Calendar startTime;
	
	@Column(name = "estimated_end_date",nullable=true)
    private Calendar estimatedEndDate;
	
	@Column(name = "web_app_link",nullable=true)
    private String webAppLink;
	
	@Column(name = "android_app_link",nullable=true)
    private String androidAppLink;
	
	@Column(name = "apple_app_link",nullable=true)
    private String appleAppLink;
	
	@Column(name = "is_testimonial_present",nullable=true)
    private boolean isTestimonialPresent;
	
	@Column(name = "is_referenceable_in_public_domain",nullable=true)
    private boolean isReferenceableInPublicDomain;
	
	@Column(name = "business_highlighted_doc_url",nullable=true)
    private String businessHighlightDocUrl;
	
	@Column(name = "case_study_doc_url",nullable=true)
    private String caseStudyDocUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public ApplicationType getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(ApplicationType applicationType) {
		this.applicationType = applicationType;
	}

	public EngagementType getEngagementType() {
		return engagementType;
	}

	public void setEngagementType(EngagementType engagementType) {
		this.engagementType = engagementType;
	}

	public List<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
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
	
	

}
