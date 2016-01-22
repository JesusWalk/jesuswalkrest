package com.jesuswalk.entity;

import org.mongodb.morphia.annotations.Entity;

@Entity("Token")
public class Token extends BaseEntity{
	
	private String studentId;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
}
