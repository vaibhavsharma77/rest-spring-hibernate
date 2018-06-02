package com.myapp.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveUser(UserDetails userDetails) {
		usDao.save(userDetails);
		Response response=Response.status(201).build();
		return response;
	}

	@GET
	@Path("userinfo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetails> getUserDetails() {
		List<UserDetails> users = usDao.getUsers();
		return users;
	}

}
