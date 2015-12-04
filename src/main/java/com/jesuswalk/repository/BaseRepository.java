package com.jesuswalk.repository;

import java.util.List;

import org.bson.types.ObjectId;

import com.jesuswalk.entity.BaseEntity;

public interface BaseRepository<T extends BaseEntity> {

	ObjectId create(T entity);
	T retrieve(ObjectId id);
	List<T> retrieveAll();
	void update(T entity);
	void delete(T entity);
	
}
