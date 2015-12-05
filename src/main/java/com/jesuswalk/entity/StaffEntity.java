package com.jesuswalk.entity;

import org.mongodb.morphia.annotations.Entity;

@Entity("Staff")
public class StaffEntity extends UserEntity {
	
	private boolean isCounseling;

	public boolean isCounseling() {
		return isCounseling;
	}

	public void setCounseling(boolean isCounseling) {
		this.isCounseling = isCounseling;
	}
	
}
