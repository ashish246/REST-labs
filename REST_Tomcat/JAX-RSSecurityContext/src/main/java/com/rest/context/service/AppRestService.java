package com.rest.context.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("/app")
public class AppRestService {

	@GET
	@Path("/{param}")
	public String printMessage(@PathParam("param") String msg,
			@Context SecurityContext sc) {

		if (sc.isUserInRole("operator"))
			return "Restful example for operator: " + msg;
		throw new SecurityException("Operator is unauthorized.");
	}

	@GET
	@Path("/admin/{param}")
	public String viewMessage(@PathParam("param") String msg,
			@Context SecurityContext sc) {

		if (sc.isUserInRole("admin"))
			return "Restful example for admin: " + msg;
		throw new SecurityException("Operator is unauthorized for user: "
				+ sc.getUserPrincipal().getName());

	}

}