package com.jesuswalk.controller;

import com.jesuswalk.entity.CounselorEntity;
import com.jesuswalk.repository.CounselorRepository;

public class CounselorController extends UserController<CounselorEntity> implements CounselorRepository {
	
	public CounselorController() {
		super(CounselorEntity.class);
	}

}
