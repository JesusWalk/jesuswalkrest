package com.jesuswalk.controller;

import com.jesuswalk.entity.StaffEntity;
import com.jesuswalk.repository.StaffRepository;

public class StaffController extends UserController<StaffEntity> implements StaffRepository{
	
	public StaffController() {
		super(StaffEntity.class);
	}
}
