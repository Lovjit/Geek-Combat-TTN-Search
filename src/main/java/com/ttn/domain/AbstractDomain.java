package com.ttn.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class AbstractDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "date_created",nullable=true)
    private Calendar dateCreated = Calendar.getInstance();
	
	@Column(name = "last_updated",nullable=true)
    private Calendar lastUpdated = Calendar.getInstance();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@PrePersist
	protected void onCreate() {
		dateCreated = Calendar.getInstance();
	}

	@PreUpdate
	protected void onUpdate() {
		lastUpdated = Calendar.getInstance();
	}

}
