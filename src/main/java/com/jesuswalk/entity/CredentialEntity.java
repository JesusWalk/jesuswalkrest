package com.jesuswalk.entity;

import org.mongodb.morphia.annotations.Entity;

@Entity("Credential")
public class CredentialEntity extends BaseEntity {

	private String email;
	private String password;
	private String type;
		
	private String userId;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
