package com.jesuswalk.controller;

import com.jesuswalk.entity.UserEntity;
import com.jesuswalk.repository.UserRepository;

public class UserController extends BaseController<UserEntity> implements UserRepository {

	public UserController() {
		super(UserEntity.class);
		// TODO Auto-generated constructor stub
	}

}
