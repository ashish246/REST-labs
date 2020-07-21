package com.rest.annot.service;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/app")
@PermitAll
public class AppRestService {

	@RolesAllowed("operator")
	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example for operator: " + msg;

		return Response.status(200).entity(result).build();

	}

	@RolesAllowed("admin")
	@GET
	@Path("/admin/{param}")
	public Response viewMessage(@PathParam("param") String msg) {

		String result = "Restful example for admin: " + msg;

		return Response.status(200).entity(result).build();

	}

}