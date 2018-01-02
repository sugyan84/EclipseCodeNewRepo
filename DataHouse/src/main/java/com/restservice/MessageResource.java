package com.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/message")
public class MessageResource
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel getMessage()
	{
		UserModel todo = new UserModel();
		return todo;
	}
}
