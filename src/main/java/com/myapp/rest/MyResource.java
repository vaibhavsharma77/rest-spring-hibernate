package com.myapp.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.dao.UserdetailsDAO;
import com.myapp.model.UserDetails;

@Path("users")
public class MyResource {
	@Autowired
	UserdetailsDAO usDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetails> getAllUsersDetails() {
		List<UserDetails> users = usDao.getAllUsers();
		return users;
	}

	@GET
	@Path(value = "{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDetails getUserDetail(@PathParam("id") int id) {
		UserDetails user = usDao.getUsers(id);
		return user;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveUser(UserDetails userDetails) {
		usDao.save(userDetails);
		Response response = Response.status(201).build();
		return response;
	}

	@DELETE
	@Path(value = "{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUserDetail(@PathParam("id") int id) {
		usDao.deleteUsers(id);
		return Response.status(Response.Status.OK).build();
	}

	/*
	 * @PUT
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * updateUser(UserDetails userDetails) { usDao.updateInfo(userdetails);
	 * return Response.status(Response.Status.ACCEPTED).build(); }
	 */

}
