package com.jesuswalk.controller;

import java.util.List;

import org.mongodb.morphia.query.Query;

import com.jesuswalk.entity.StudentEntity;
import com.jesuswalk.repository.StudentRepository;

public class StudentController extends UserController<StudentEntity> implements StudentRepository {

	public StudentController() {
		super(StudentEntity.class);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<StudentEntity> retrieveByGroupName(String groupName) {
		
		Query q = datastore.createQuery(type).filter("groupName", groupName);
		if(q == null)
			return null;
		
		return q.asList();
	}

}
