package com.jesuswalk.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.jesuswalk.model.Email;

/*
 * mailTo = info@jesuswalkyouth.com; mokada@jesuswalkyouth.com
 * Outgoing Server:	mail.jesuswalkyouth.com
   SMTP Port: 587
 */

@Path("/")
public class AppService {

	@POST
	@Path("/email")
	@Consumes("application/json")
	@Produces("application/json")
	public Response register(Email email) {
		String message = "";
		message = email.getName() + " wants to know more about JesusWalk\n";
		message += "Email: " + email.getEmailFrom();
		message += "Message: " 	 + email.getMessage();		

		
	return Response.status(Response.Status.OK).build();
		
	// return Response.status(Response.Status.EXPECTATION_FAILED).build();
	}
}
