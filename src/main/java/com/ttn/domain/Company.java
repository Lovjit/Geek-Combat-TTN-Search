package com.ttn.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends AbstractDomain {

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "company_description")
	private String companyDescription;

	@OneToMany(mappedBy = "company")
	private List<Project> projects;

	@OneToOne(cascade = CascadeType.ALL)
	private CompanyType companyType;

	@OneToOne(cascade = CascadeType.ALL)
	private IndustryType industryType;

	@Column(name = "testimonial")
	private String testimonial;

	@Column(name = "public_reference")
	private Boolean referenceInPublicDomain;

	@Column(name = "highlight_link")
	private String highlightsLink;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public IndustryType getIndustryType() {
		return industryType;
	}

	public void setIndustryType(IndustryType industryType) {
		this.industryType = industryType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
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

}
