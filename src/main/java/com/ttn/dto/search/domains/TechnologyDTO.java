package com.ttn.dto.search.domains;

import com.ttn.domain.Technology;
import com.ttn.dto.GenericCO;

public class TechnologyDTO implements GenericCO<Long> {

	private Long id;

	private String type;

	private String name;

	private String contentType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void update(Technology technology) {
		this.setId(technology.getId());
		this.setType(technology.getTechnologyType().getName());
		this.setName(technology.getName());
	}

}
