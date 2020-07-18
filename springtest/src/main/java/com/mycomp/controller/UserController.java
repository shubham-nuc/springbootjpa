/**
 * 
 */
package com.mycomp.controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mycomp.Model.UserDTO;
import com.mycomp.service.IUserService;

import ch.qos.logback.core.status.Status;

/**
 * @author shubham
 *
 */
@RestController
@Path("/userapi")
public class UserController {
	//http://localhost:8080/app/v1/userapi/users
	@Autowired
	private IUserService userService;
	
	@Value("${user.success.msg}")
	private String successMsg;

	@Value("${user.delete.msg}")
	private String deleteMsg;

	@Value("${no.user.msg}")
	private String noUserMsg;
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		Optional<List<UserDTO>> users=userService.getAllUsers();
		if(users.get().isEmpty()) {
			return Response.status(HttpStatus.NOT_FOUND.value()).entity(noUserMsg).build();
		}
		return Response.status(HttpStatus.OK.value()).entity(users.get()).build();		
	}
	
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneUser(@QueryParam("id") Long id,@QueryParam("name") String name ) {
		if(null!=id) {
			Optional<UserDTO> userDto= userService.getUsersById(id);
			if(userDto.isPresent()) {
				return Response.status(HttpStatus.OK.value()).entity(userDto.get()).build();
			}
			return  Response.status(HttpStatus.NOT_FOUND.value()).entity(noUserMsg).build();
		}
		else if(name != null) {
			Optional<UserDTO> userDto= userService.getUsersByName(name);
			if(userDto.isPresent()) {
			return Response.status(HttpStatus.OK.value()).entity(userDto.get()).build();
			}
			return  Response.status(HttpStatus.NOT_FOUND.value()).entity(noUserMsg).build();
		}
		return Response.status(HttpStatus.BAD_REQUEST.value()).entity("No/Wrong Input Parameter").build();
	}
	
	@POST
	@Path("/addUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addUser(@RequestBody UserDTO user) {
		Optional<UserDTO> userDto= userService.addUser(user);
		if(userDto.isPresent()) {
			return successMsg;
		}
		return noUserMsg;
	}
	
	@DELETE
	@Path("/deleteUser/{userId}")
	public String deleteUser(@PathParam("userId") Long userId) {
		return userService.deleteUser(userId);
	}
	

}
