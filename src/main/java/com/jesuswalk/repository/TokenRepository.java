package com.jesuswalk.repository;

import com.jesuswalk.entity.Token;

public interface TokenRepository extends BaseRepository<Token> {

	boolean isActive(String id);
	
}
