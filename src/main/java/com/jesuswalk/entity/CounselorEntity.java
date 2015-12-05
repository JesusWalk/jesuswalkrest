package com.jesuswalk.entity;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

@Entity("Counselor")
public class CounselorEntity extends UserEntity{

	private String groupName;
	private String groupGrade;	
	
	@Reference
	private List<StudentEntity>	students;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupGrade() {
		return groupGrade;
	}

	public void setGroupGrade(String groupGrade) {
		this.groupGrade = groupGrade;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
	
}
