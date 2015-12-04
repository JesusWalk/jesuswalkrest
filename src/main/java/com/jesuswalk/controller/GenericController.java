package com.jesuswalk.controller;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import com.jesuswalk.config.MongoDB;
import com.jesuswalk.entity.BaseEntity;

public class GenericController {

	private final Datastore datastore;

	public GenericController() {
		datastore = MongoDB.instance().getDatabase();
	}

	public <E extends BaseEntity> ObjectId persist(E entity) {
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
	}

}
