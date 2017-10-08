package com.ttn.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country extends AbstractDomain{
	
	@Column(name = "name")
	private String name;
	
	@Column(name="sortname")
	private String sortname;
	
	@Column(name="phonecode")
	private Long phonecode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public Long getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(Long phonecode) {
		this.phonecode = phonecode;
	}
	
}
