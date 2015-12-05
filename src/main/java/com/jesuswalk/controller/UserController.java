package com.jesuswalk.controller;

import java.util.List;

import org.mongodb.morphia.query.Query;

import com.jesuswalk.entity.UserEntity;
import com.jesuswalk.repository.UserRepository;

public class UserController<T extends UserEntity> extends BaseController<T> implements UserRepository<T> {

	Class<T> type;
	
	public UserController(Class<T> type) {
		super(type);
		this.type = type;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> retrieveByFirstName(String firstName) {

		Query q = datastore.createQuery(type).filter("firstName", firstName);
		if(q == null)
			return null;
		
		return q.asList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> retrieveByLastName(String lastName) {
		
		Query q = datastore.createQuery(type).filter("lastName", lastName);
		if(q == null)
			return null;
		
		return q.asList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> retrieveByAge(int age) {
		Query q = datastore.createQuery(type).filter("age", age);
		if(q == null)
			return null;
		
		return q.asList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> retrieveByChurch(String churchId) {
		
		Query q = datastore.createQuery(type).filter("church", churchId);
		if(q == null)
			return null;
		
		return q.asList();
	}

}
