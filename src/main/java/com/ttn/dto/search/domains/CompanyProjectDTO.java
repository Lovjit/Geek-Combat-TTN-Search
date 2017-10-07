package com.ttn.dto.search.domains;

import java.util.List;

public class CompanyProjectDTO {

	private Long id;

	private String name;

	private List<TechnologyDTO> technologies;

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

	public List<TechnologyDTO> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<TechnologyDTO> technologies) {
		this.technologies = technologies;
	}

}
