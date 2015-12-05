package com.jesuswalk.entity;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

@Entity("Student")
public class StudentEntity extends UserEntity{

	private String groupName;
	private String grade;
	
	@Embedded
	private Mother mother;
	
	@Embedded
	private Father father;
	
	@Reference
	private List<CounselorEntity> counselors;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<CounselorEntity> getCounselors() {
		return counselors;
	}

	public Mother getMother() {
		return mother;
	}

	public void setMother(Mother mother) {
		this.mother = mother;
	}

	public Father getFather() {
		return father;
	}

	public void setFather(Father father) {
		this.father = father;
	}

	public void setCounselors(List<CounselorEntity> counselors) {
		this.counselors = counselors;
	}
	
}
