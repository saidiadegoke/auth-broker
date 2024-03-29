package com.flexipgroup.app.response;

public class UserResponse {
	
	//the response model can not contain password because this info will be return
	private String userId; 
	private String email;
	private String token;
	
	//getters and setters
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	
	
}
