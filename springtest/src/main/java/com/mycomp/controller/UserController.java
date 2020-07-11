/**
 * 
 */
package com.mycomp.controller;

import javax.ws.rs.core.MediaType;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.Model.UserDTO;
import com.mycomp.service.IUserService;

/**
 * @author shubham
 *
 */
@RestController
@Path("/userapi")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO getOneUser(@QueryParam("id") int id,@QueryParam("name") String name ) {
		if(id!=0) {
			return userService.getUsersById(id);
		}
		else if(name != null) {
			return userService.getUsersByName(name);
		}
		return null;
	}
	
	@POST
	@Path("/addUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addUser(@RequestBody UserDTO user) {
		return userService.addUser(user);
	}
	
	@DELETE
	@Path("/deleteUser/{userId}")
	public String deleteUser(@PathParam("userId") int userId) {
		return userService.deleteUser(userId);
	}
	

}
