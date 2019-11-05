package com.flexipgroup.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//table name using entity
@Entity(name="users")

public class UserEntity implements Serializable {
		
		/**
	 * serial version UID number
	 */
	private static final long serialVersionUID = 2334523234173750353L;

		@Id
		@GeneratedValue
		private long id;
		
		@Column(nullable = false)
		private String userId;
		
		@Column(nullable = false, length = 150)
		private String email;
		
		@Column(nullable = false)
		private String encryptedPassword;
		
		private String emailVerificationToken;
		
		@Column(nullable = false)
		private Boolean emailVerificationStatus = false;

		
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEncryptedPassword() {
			return encryptedPassword;
		}

		public void setEncryptedPassword(String encryptedPassword) {
			this.encryptedPassword = encryptedPassword;
		}

		public String getEmailVerificationToken() {
			return emailVerificationToken;
		}

		public void setEmailVerificationToken(String emailVerificationToken) {
			this.emailVerificationToken = emailVerificationToken;
		}

		public Boolean getEmailVerificationStatus() {
			return emailVerificationStatus;
		}

		public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
			this.emailVerificationStatus = emailVerificationStatus;
		}
		
		
		


}
