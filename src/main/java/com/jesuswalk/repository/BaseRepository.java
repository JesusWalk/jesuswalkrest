package com.jesuswalk.repository;

import java.util.List;

import com.jesuswalk.entity.BaseEntity;
import com.mongodb.client.result.UpdateResult;

public interface BaseRepository<T extends BaseEntity> {

	String create(T entity);
	T retrieve(String id);
	List<T> retrieveAll();
	UpdateResult update(T entity);
	void delete(T entity);
	
}
