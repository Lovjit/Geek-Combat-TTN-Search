package com.ttn.dto.search.domains;

import java.util.List;

import com.ttn.dto.GenericCO;

public class DocumentDTO implements GenericCO<String> {

	private String id;

	private List<BasicContentDTO> project;

	private BasicContentDTO company;

	private String industryType;

	private String downloadLink;

	private String data;

	private String contentType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BasicContentDTO> getProject() {
		return project;
	}

	public void setProject(List<BasicContentDTO> project) {
		this.project = project;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public BasicContentDTO getCompany() {
		return company;
	}

	public void setCompany(BasicContentDTO company) {
		this.company = company;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
