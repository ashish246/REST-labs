package com.jersey.demo;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 * Inject directly with @HeaderParam
 * 
 * Pragmatically via @Context
 * 
 * Alternatively, you can use @Context to get “javax.ws.rs.core.HttpHeaders”
 * directly,
 * 
 * it gets the browser “user-agent” from request header.
 * 
 * @author Administrator
 *
 */
@Path("/users")
public class UserService {

	@GET
	@Path("/get/header")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {

		return Response.status(200)
				.entity("addUser is called, userAgent : " + userAgent).build();

	}

	@GET
	@Path("/get/context")
	public Response addUser(@Context HttpHeaders headers) {

		String userAgent = headers.getRequestHeader("user-agent").get(0);

		return Response.status(200)
				.entity("addUser is called, userAgent : " + userAgent).build();

	}

}
