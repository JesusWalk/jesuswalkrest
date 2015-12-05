package com.jesuswalk.controller;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import com.jesuswalk.config.MongoDB;
import com.jesuswalk.entity.BaseEntity;
import com.jesuswalk.repository.BaseRepository;
import com.mongodb.client.result.UpdateResult;

public class BaseController<T extends BaseEntity> implements BaseRepository<T> {

	protected final Datastore datastore;

	Class<T> type;
	
	public BaseController(Class<T> type) {
		datastore = MongoDB.instance().getDatabase();
		this.type = type;
	}

	@Override
	public String create(T entity) {
		datastore.save(entity);
		return entity.getId();
	}

	@Override
	public T retrieve(String id) {
		// TODO Auto-generated method stub
		 return datastore.find(type).field("id").equal(id).get();
	}

	@Override
	public List<T> retrieveAll() {
		Query<T> q = datastore.find(type);
		if(q == null)
			return null;
		
		return q.asList();
	}

	@Override
	public UpdateResult update(T entity) {
		//datastore.up
		
		return null;
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		datastore.delete(entity);
		
	}
}
