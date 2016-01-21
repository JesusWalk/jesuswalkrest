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
import com.jesuswalk.controller.StudentController;
import com.jesuswalk.entity.StudentEntity;

@Secured
@Path("/students")
public class StudentService {
	
	StudentController controller = new StudentController();
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createStudent(StudentEntity student) {
		
		String id = controller.create(student);
		
		return Response.status(Response.Status.OK).entity(id).build();
	}
	
	@GET
	@Produces("application/json")
	public Response retrieveStudents() {
		
		List<StudentEntity> students = controller.retrieveAll();
		
		return Response.status(Response.Status.OK).entity(students).build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateStudent(StudentEntity student) {
		
		controller.update(student);
		
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Consumes("application/json")
	public Response deleteStudent(StudentEntity student) {
		
		controller.delete(student);
		
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
	@Path("/firstName/{firstName}")
	@Produces("application/json")
	public Response retrieveStudentByFirstName(@PathParam("firstName") String firstName) {
		
		List<StudentEntity> students = controller.retrieveByFirstName(firstName);
		
		return Response.status(Response.Status.OK).entity(students).build();
	}
	
	@GET
	@Path("/lastName/{lastName}")
	@Produces("application/json")
	public Response retrieveStudentByLastName(@PathParam("lastName") String lastName) {
		
		List<StudentEntity> students = controller.retrieveByLastName(lastName);
		
		return Response.status(Response.Status.OK).entity(students).build();
	}
	
	@GET
	@Path("/age/{age}")
	@Produces("application/json")
	public Response retrieveStudentByAge(@PathParam("age") String age) {
		
		List<StudentEntity> students = controller.retrieveByAge(Integer.parseInt(age));
		
		return Response.status(Response.Status.OK).entity(students).build();
	}
	
	@GET
	@Path("/churchId/{churchId}")
	@Produces("application/json")
	public Response retrieveStudentByChurch(@PathParam("churchId") String churchId) {
		
		List<StudentEntity> students = controller.retrieveByChurch(churchId);
		
		return Response.status(Response.Status.OK).entity(students).build();
	}
	
	@GET
	@Path("/groupName/{groupName}")
	@Produces("application/json")
	public Response retrieveStudentByGroupName(@PathParam("groupName") String groupName) {
		
		List<StudentEntity> students = controller.retrieveByGroupName(groupName);
		
		return Response.status(Response.Status.OK).entity(students).build();
	}

}
