package com.resteasy.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/xml/user")
public class XMLService {

	@GET
	@Path("/get")
	@Produces("application/xml")
	public User getUserInXML() {

		User user = new User();
		user.setUsername("Ashsih");
		user.setPassword("sdihdskvhdsh");
		user.setPin(123456);

		return user;

	}

}