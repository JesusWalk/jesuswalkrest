package com.jesuswalk.entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

@Entity("Credential")
public class CredentialEntity extends BaseEntity {

	private String email;
	private String password;
	
	@Reference
	private UserEntity user;
	
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
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
