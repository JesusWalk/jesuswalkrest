package com.jesuswalk.config;

import java.util.Arrays;
import java.util.logging.Logger;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.jesuswalk.entity.BaseEntity;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class MongoDB {

	public static final String DB_HOST = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
	public static final int DB_PORT = Integer.parseInt(System.getenv("OPENSHIFT_MONGODB_DB_PORT"));
	public static final String DB_NAME = "jesuswalkrest";

	public String DB_USER = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
	public String DB_PASSWORD = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
	
	private static final Logger LOG = Logger.getLogger(MongoDB.class.getName());

	private static final MongoDB INSTANCE = new MongoDB();

	private Datastore datastore;
	
	private MongoDB() {
		 InitializeMongo();
	}

	private void InitializeMongo() {
		try {
		MongoCredential credential = MongoCredential.createCredential(DB_USER, DB_NAME, DB_PASSWORD.toCharArray());
		MongoClientOptions mongoOptions = MongoClientOptions.builder()
					.socketTimeout(60000) // Wait 1m for a query to finish, https://jira.mongodb.org/browse/JAVA-1076
					.connectTimeout(15000) // Try the initial connection for 15s, http://blog.mongolab.com/2013/10/do-you-want-a-timeout/
					.maxConnectionIdleTime(600000) // Keep idle connections for 10m, so we discard failed connections quickly
					.readPreference(ReadPreference.primaryPreferred()) // Read from the primary, if not available use a secondary
					.build();
		  MongoClient mongoClient;
		  mongoClient = new MongoClient(new ServerAddress(DB_HOST, DB_PORT), Arrays.asList(credential), mongoOptions );
		  mongoClient.setWriteConcern(WriteConcern.SAFE);
		  datastore = new Morphia()
				  .mapPackage(BaseEntity.class.getPackage().getName())
				  .createDatastore(mongoClient, DB_NAME);
		  datastore.ensureIndexes();
		  datastore.ensureCaps();
		} catch (MongoException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
		}
		 
		  LOG.info("Connection to database '" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "' initialized");
	}
	
	
	public static MongoDB instance() {
		return INSTANCE;
	}

	// Creating the mongo connection is expensive - (re)use a singleton for
	// performance reasons.
	// Both the underlying Java driver and Datastore are thread safe.
	public Datastore getDatabase() {
		return datastore;
	}
}
