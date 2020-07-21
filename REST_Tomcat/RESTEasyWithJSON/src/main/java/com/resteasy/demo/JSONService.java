package com.resteasy.demo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Disabled RESTEasy auto scanning. You must disabled the RESTEasy auto
 * scanning, and register your REST service manually, else will get the error:
 * Illegal To Inject A Message Body Into A Singleton Into Public
 * Org.Codehaus.Jackson.Jaxrs.JacksonJsonProvider
 * 
 * @author Administrator
 *
 */
@Path("/json/product")
public class JSONService {

	@GET
	@Path("/get")
	@Produces("application/json")
	public Product getProductInJSON() {

		Product product = new Product();
		product.setName("iPad 3");
		product.setQty(999);

		return product;

	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Product product) {

		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();

	}

}
