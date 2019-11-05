package com.flexipgroup.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//table name using entity
@Entity(name="services")

public class ServiceEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false, length = 200)
	private String name;
	
	@Column(nullable = false, length = 250)
	private String description;

	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
