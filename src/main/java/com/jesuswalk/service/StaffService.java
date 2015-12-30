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
import com.jesuswalk.controller.StaffController;
import com.jesuswalk.entity.StaffEntity;

@Path("/staffs")
public class StaffService {

	StaffController controller = new StaffController();
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createStaff(StaffEntity staff) {
		
		String id = controller.create(staff);
		
		return Response.status(Response.Status.OK).entity(id).build();
	}
	
	@GET
	@Produces("application/json")
	public Response retrieveStaffs() {
		
		List<StaffEntity> staffs = controller.retrieveAll();
		
		return Response.status(Response.Status.OK).entity(staffs).build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateStaff(StaffEntity staff){
		
		controller.update(staff);
		
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Consumes("application/json")
	public Response deleteStaff(StaffEntity staff) {
		
		controller.delete(staff);
		
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
	@Path("/firstName/{firstName}")
	@Produces("application/json")
	public Response retrieveStaffByFirstName(@PathParam("firstName") String firstName) {
		
		List<StaffEntity> staffs = controller.retrieveByFirstName(firstName);
		
		return Response.status(Response.Status.OK).entity(staffs).build();
	}
	
	@GET
	@Path("/lastName/{lastName}")
	@Produces("application/json")
	public Response retrieveStaffByLastName(@PathParam("lastName") String lastName) {
		
		List<StaffEntity> staffs = controller.retrieveByLastName(lastName);
		
		return Response.status(Response.Status.OK).entity(staffs).build();
	}
	
	@GET
	@Path("/age/{age}")
	@Produces("application/json")
	public Response retrieveStaffByAge(@PathParam("age") String age) {
		
		List<StaffEntity> staffs = controller.retrieveByAge(Integer.parseInt(age));
		
		return Response.status(Response.Status.OK).entity(staffs).build();
	}
	
	@GET
	@Path("/churchId/{churchId}")
	@Produces("application/json")
	public Response retrieveStaffByChurch(@PathParam("churchId") String churchId) {
		
		List<StaffEntity> staffs = controller.retrieveByChurch(churchId);
		
		return Response.status(Response.Status.OK).entity(staffs).build();
	}
}
