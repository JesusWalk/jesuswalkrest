package com.jesuswalk.entity;

import org.mongodb.morphia.annotations.Entity;

@Entity("Token")
public class Token extends BaseEntity{
	
	private Long studentId;
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
}
