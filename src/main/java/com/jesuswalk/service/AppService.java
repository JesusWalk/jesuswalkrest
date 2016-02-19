package com.jesuswalk.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
		
		Email email2 = new Email();
		email2.setEmailFrom("manamiokada1005@gmail.com");
		email2.setMessage("Hello I was wondering if there will be a promo night in the LA area? Thanks");
		email2.setName("Joe Smith");
		email2.setSubject("Promo Night");
		
		String mailSender = email2.getName();
		String mailTo = "mokada@jesuswalkyouth.com";
		String mailFrom = "homepage@jesuswalkyouth.com";
		String mailSubject = mailSender + " left a message on the JW homepage!";
		String mailContent = "Sender email: " + email2.getEmailFrom() + "\n" 
						+ "Message subject: " + email2.getSubject() + "\n" 
						+ "Message content: \n\n" + email2.getMessage();
		
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.host", "mail.jesuswalkyouth.com");
			Session emailSession = Session.getDefaultInstance(properties);
			
			Message emailMessage = new MimeMessage(emailSession);
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
			emailMessage.setFrom(new InternetAddress(mailFrom));
			emailMessage.setSubject(mailSubject);
			emailMessage.setText(mailContent);
			
			emailSession.setDebug(true);
			Transport.send(emailMessage);
		} catch (Exception e) {
			return Response.status(Response.Status.EXPECTATION_FAILED).build();
		}
		
	return Response.status(Response.Status.OK).build();
		
	// return Response.status(Response.Status.EXPECTATION_FAILED).build();
	}
}
