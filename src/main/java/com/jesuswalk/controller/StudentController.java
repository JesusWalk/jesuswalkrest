package com.jesuswalk.controller;

import com.jesuswalk.entity.StudentEntity;
import com.jesuswalk.repository.StudentRepository;

public class StudentController extends UserController<StudentEntity> implements StudentRepository {

	public StudentController() {
		super(StudentEntity.class);
		// TODO Auto-generated constructor stub
	}

}
