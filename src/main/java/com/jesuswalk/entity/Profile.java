package com.jesuswalk.entity;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Profile {

	private String homeNumber;
	private String cellNumber;
	private String email;
	
	private String instagram;
	private String snapchat;
	private String twitter;
	
	public String getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	public String getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getSnapchat() {
		return snapchat;
	}
	public void setSnapchat(String snapchat) {
		this.snapchat = snapchat;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	
}
