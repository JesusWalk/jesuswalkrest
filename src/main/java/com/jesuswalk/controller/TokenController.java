package com.jesuswalk.controller;

import com.jesuswalk.entity.Token;
import com.jesuswalk.repository.TokenRepository;

public class TokenController extends BaseController<Token> implements TokenRepository{

	
	public TokenController() {
		super(Token.class);
	}

	@Override
	public boolean isActive(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
