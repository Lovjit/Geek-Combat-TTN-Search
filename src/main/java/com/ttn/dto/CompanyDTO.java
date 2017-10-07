package com.ttn.dto;

public class CompanyDTO {
	
	private Long id;
	
	private String name;
	
	private String companyDescription;
	
	private Long companyType;
	
	private Long industryType;
	
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

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public Long getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Long companyType) {
		this.companyType = companyType;
	}

	public Long getIndustryType() {
		return industryType;
	}

	public void setIndustryType(Long industryType) {
		this.industryType = industryType;
	}
	
	

}
