package com.jesuswalk.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.jesuswalk.controller.UserController;
import com.jesuswalk.entity.UserEntity;


@Path("/users")
public class UserService {
	
	UserController controller = new UserController();
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createUser(UserEntity user) {
		
		ObjectId id = controller.create(user);
		
		return Response.status(Response.Status.OK).entity(id).build();
	}
	
	@GET
	@Produces("application/json")
	public Response retrieveUsers() {
		
		List<UserEntity> users = controller.retrieveAll();
		
		return Response.status(Response.Status.OK).entity(users).build();
	}

}
