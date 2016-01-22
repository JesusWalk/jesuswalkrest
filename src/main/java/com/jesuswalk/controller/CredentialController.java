package com.jesuswalk.controller;

import com.jesuswalk.entity.CredentialEntity;
import com.jesuswalk.repository.CredentialRepository;

public class CredentialController extends BaseController<CredentialEntity> implements CredentialRepository{

	public CredentialController() {
		super (CredentialEntity.class);
	}

	@Override
	public CredentialEntity retrieveCredentialsByEmail(String email) {
		return datastore.find(type).field("email").equal(email).get();
	}
	
}
