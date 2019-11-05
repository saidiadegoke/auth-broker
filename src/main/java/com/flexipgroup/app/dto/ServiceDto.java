package com.flexipgroup.app.dto;

import java.io.Serializable;

public class ServiceDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1278984181963192948L;

	
	private long id;
	private String name;
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
