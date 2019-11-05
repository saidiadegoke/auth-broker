package com.flexipgroup.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//table name using entity
@Entity(name="tokens")

public class TokenEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String userId;
	
	@Column(nullable = false, length = 255)
	private String token;
	
	
	private Date expiresAt;
	
	private Date createdAt;
	
	
	//getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	


}
