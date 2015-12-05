package com.jesuswalk.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.jesuswalk.controller.StudentController;
import com.jesuswalk.entity.StudentEntity;

@Path("/students")
public class StudentService {
	
	StudentController controller = new StudentController();
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createStudent(StudentEntity student) {
		
		ObjectId id = controller.create(student);
		
		return Response.status(Response.Status.OK).entity(id).build();
	}
	
	@GET
	@Produces("application/json")
	public Response retrieveStudents() {
		
		List<StudentEntity> students = controller.retrieveAll();
		
		return Response.status(Response.Status.OK).entity(students).build();
	}

}
