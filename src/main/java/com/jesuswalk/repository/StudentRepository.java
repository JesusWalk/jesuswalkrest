package com.jesuswalk.repository;

import java.util.List;

import com.jesuswalk.entity.StudentEntity;

public interface StudentRepository extends UserRepository<StudentEntity> {
	
	List<StudentEntity> retrieveByGroupName(String groupName);
	
}
