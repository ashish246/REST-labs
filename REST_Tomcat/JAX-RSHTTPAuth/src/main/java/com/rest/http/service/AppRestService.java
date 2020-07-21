package com.rest.http.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/app")
public class AppRestService {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example for operator: " + msg;

		return Response.status(200).entity(result).build();

	}

	@GET
	@Path("/admin/{param}")
	public Response viewMessage(@PathParam("param") String msg) {

		String result = "Restful example for admin: " + msg;

		return Response.status(200).entity(result).build();

	}

}