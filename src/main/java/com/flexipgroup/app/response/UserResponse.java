package com.flexipgroup.app.response;

public class UserResponse {
	
	//the response model can not contain password because this info will be return
	private String userId; 
	private String email;
	
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

	
	
}
