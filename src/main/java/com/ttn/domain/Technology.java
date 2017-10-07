package com.ttn.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ttn.jdbcCallbacks.Searchable;

@Entity
@Table(name = "technology")
@EntityListeners({Searchable.class})
public class Technology extends AbstractDomain {

	@OneToOne(cascade = CascadeType.ALL)
	private TechnologyType technologyType;

	@Column(name = "name")
	private String name;

	public TechnologyType getTechnologyType() {
		return technologyType;
	}

	public void setTechnologyType(TechnologyType technologyType) {
		this.technologyType = technologyType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
