package com.jesuswalk.service;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;

import com.jesuswalk.authentication.Secured;
import com.jesuswalk.controller.TokenController;
import com.jesuswalk.entity.Token;

@Secured 
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

	com.jesuswalk.controller.TokenController controller = new TokenController();

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		// Get the HTTP Authorization header from the request
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		// Check if the HTTP Authorization header is present and formatted
		// correctly
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new NotAuthorizedException("Authorization header must be provided"); //TODO: Uncomment for Security
		}

		// Extract the token from the HTTP Authorization header
		String tokenKey = authorizationHeader.substring("Bearer".length()).trim();

		// Validate the token
		if (!validateToken(tokenKey)) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build()); //TODO: Uncomment for Security
		}

	}

	private boolean validateToken(String tokenKey) {
		Token token = controller.retrieve(tokenKey);
		
		if(token == null)
			return false;
		
		Date start = token.getCreationDate();
		DateTime tokenTime = new DateTime(start);
		DateTime currentTime = new DateTime();
		
		int hours = Hours.hoursBetween(tokenTime, currentTime).getHours() % 24;
		int minutes = Minutes.minutesBetween(tokenTime, currentTime).getMinutes() % 60;
		
		if(minutes > 120 || hours > 2) {
			controller.delete(token);
			return false;
		}
		
		return true;
	}

}
