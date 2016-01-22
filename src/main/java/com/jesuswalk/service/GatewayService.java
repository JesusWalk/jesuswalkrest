package com.jesuswalk.service;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.jesuswalk.controller.CredentialController;
import com.jesuswalk.controller.StudentController;
import com.jesuswalk.controller.TokenController;
import com.jesuswalk.entity.CredentialEntity;
import com.jesuswalk.entity.StudentEntity;
import com.jesuswalk.entity.Token;

@Path("/")
public class GatewayService {

	CredentialController credentialController = new CredentialController();
	StudentController studentController = new StudentController();
	TokenController tokenController = new TokenController();

	@POST
	@Path("/register/credentials")
	@Consumes("application/json")
	@Produces("application/json")
	public Response register(CredentialEntity credentials) {

		String id = credentialController.create(credentials);

		return Response.status(Response.Status.OK).entity(id).build();
	}

	@POST
	@Path("/register/student")
	@Consumes("application/json")
	@Produces("application/json")
	public Response register(StudentEntity student) {

		String id = studentController.create(student);

		return Response.status(Response.Status.OK).entity(id).build();
	}

	@POST
	@Path("/login")
	@Consumes("application/json")
	@Produces("application/json")
	public Response login(CredentialEntity credentials) {

		if (credentials == null)
			return Response.status(Response.Status.NO_CONTENT).build();

		Token token = new Token();
		StudentEntity student = authenticate(credentials);

		if (student == null)
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();

		token = issueToken(student.getId());
		return Response.ok(token).build();
	}

	private StudentEntity authenticate(CredentialEntity input) {
		CredentialEntity credentials = credentialController.retrieveCredentialsByEmail(input.getEmail());
		StudentEntity student = null;
		
		if (credentials.getPassword() == input.getPassword()) 
			student = studentController.retrieve(credentials.getUserId());
		
		return student;
	}

	private Token issueToken(String userId) {
		Token token = new Token();
		token.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		token.setStudentId(userId);
		tokenController.create(token);
		return token;
	}

}
