package com.jersey.demo;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * In JAX-RS, for user to download an image file, annotate the method with
 * @Produces("image/image-type") :
 * 
 * Put @Produces(“image/png”) on service method, for “png” image. Set
 * “Content-Disposition” in Response header to prompt a download box.
 * 
 * @author Administrator
 *
 */
@Path("/image")
public class ImageService {

	private static final String FILE_PATH = "d://uploaded/1.png";

	@GET
	@Path("/get")
	@Produces("image/png")
	public Response getFile() {

		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=image_from_server.png");
		return response.build();

	}

}