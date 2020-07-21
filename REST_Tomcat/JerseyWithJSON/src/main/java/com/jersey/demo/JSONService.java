package com.jersey.demo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * In web.xml, declares “com.sun.jersey.api.json.POJOMappingFeature” as
 * “init-param” in Jersey mapped servlet. It will make Jersey support
 * JSON/object mapping.
 * 
 * @author Administrator
 *
 */
@Path("/json/metallica")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();

	}

}