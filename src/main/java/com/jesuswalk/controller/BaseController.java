package com.jesuswalk.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import com.jesuswalk.config.MongoDB;
import com.jesuswalk.entity.BaseEntity;
import com.jesuswalk.repository.BaseRepository;

public class BaseController<T extends BaseEntity> implements BaseRepository<T> {

	private final Datastore datastore;

	Class<T> type;
	
	public BaseController(Class<T> type) {
		datastore = MongoDB.instance().getDatabase();
		this.type = type;
	}

	@Override
	public ObjectId create(T entity) {
		datastore.save(entity);
		return entity.getId();
	}

	@Override
	public T retrieve(ObjectId id) {
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
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	/*public <E extends BaseEntity> ObjectId persist(E entity) {
		datastore.save(entity);
		return entity.getId();
	}

	public <E extends BaseEntity> long count(Class<E> clazz) {
		if (clazz == null) {
			return 0;
		}

		return datastore.find(clazz).countAll();
	}

	public <E extends BaseEntity> E get(Class<E> clazz, final ObjectId id) {
		if ((clazz == null) || (id == null)) {
			return null;
		}

		return datastore.find(clazz).field("id").equal(id).get();
	}*/

}
