package com.jesuswalk.repository;

import java.util.List;

import com.jesuswalk.entity.ChurchEntity;
import com.jesuswalk.entity.UserEntity;

public interface UserRepository<T extends UserEntity> extends BaseRepository<T> {
	
	List<T> retrieveByFirstName(String firstName);
	List<T> retrieveByLastName(String lastName);
	List<T> retrieveByAge(int age);
	List<T> retrieveByChurch(ChurchEntity church);

}
