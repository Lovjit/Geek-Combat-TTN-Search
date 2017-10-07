package com.ttn.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import com.ttn.jdbcCallbacks.Searchable;

@Entity
@EntityListeners({Searchable.class})
@Table(name = "engagement_type")
public class EngagementType extends AbstractDomain {

	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
