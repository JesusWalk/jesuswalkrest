package com.jesuswalk.repository;

import com.jesuswalk.entity.CredentialEntity;

public interface CredentialRepository extends BaseRepository<CredentialEntity> {
	
	CredentialEntity retrieveCredentialsByEmail(String email);

}
