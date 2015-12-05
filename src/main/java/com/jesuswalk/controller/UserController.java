package com.jesuswalk.controller;

import java.util.List;

import com.jesuswalk.entity.ChurchEntity;
import com.jesuswalk.entity.UserEntity;
import com.jesuswalk.repository.UserRepository;

public class UserController<T extends UserEntity> extends BaseController<T> implements UserRepository<T> {

	Class<T> type;
	
	public UserController(Class<T> type) {
		super(type);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<T> retrieveByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> retrieveByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> retrieveByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> retrieveByChurch(ChurchEntity church) {
		// TODO Auto-generated method stub
		return null;
	}

}
