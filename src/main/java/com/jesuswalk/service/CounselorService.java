package com.jesuswalk.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.jesuswalk.authentication.Secured;
import com.jesuswalk.controller.CounselorController;
import com.jesuswalk.entity.CounselorEntity;

@Path("/counselors")
public class CounselorService {
	
	CounselorController controller = new CounselorController();
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createCounselor(CounselorEntity counselor) {
		
		String id = controller.create(counselor);
		
		return Response.status(Response.Status.OK).entity(id).build();
	}
	
	@GET
	@Secured 
	@Produces("application/json")
	public Response retrieveCounselors() {
		
		List<CounselorEntity> counselors = controller.retrieveAll();
		
		return Response.status(Response.Status.OK).entity(counselors).build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateCounselor(CounselorEntity counselor) {
		
		controller.update(counselor);
		
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Secured 
	@Consumes("application/json")
	public Response deleteCounselor(CounselorEntity counselor) {
		
		controller.delete(counselor);
		
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
	@Secured 
	@Path("/firstName/{firstName}")
	@Produces("application/json")
	public Response retrieveCounselorByFirstName(@PathParam("firstName") String firstName) {
		
		List<CounselorEntity> counselors = controller.retrieveByFirstName(firstName);
		
		return Response.status(Response.Status.OK).entity(counselors).build();
	}
	
	@GET
	@Secured 
	@Path("/lastName/{lastName}")
	@Produces("application/json")
	public Response retrieveCounselorByLastName(@PathParam("lastName") String lastName) {
		
		List<CounselorEntity> counselors = controller.retrieveByLastName(lastName);
		
		return Response.status(Response.Status.OK).entity(counselors).build();
	}
	
	@GET
	@Secured 
	@Path("/age/{age}")
	@Produces("application/json")
	public Response retrieveCounselorByAge(@PathParam("age") String age) {
		
		List<CounselorEntity> counselors = controller.retrieveByAge(Integer.parseInt(age));
		
		return Response.status(Response.Status.OK).entity(counselors).build();
	}
	
	@GET
	@Secured 
	@Path("/churchId/{churchId}")
	@Produces("application/json")
	public Response retrieveCounselorByChurch(@PathParam("churchId") String churchId) {
		
		List<CounselorEntity> counselors = controller.retrieveByChurch(churchId);
		
		return Response.status(Response.Status.OK).entity(counselors).build();
	}
}