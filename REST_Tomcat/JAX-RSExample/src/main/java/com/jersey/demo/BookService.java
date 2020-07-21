package com.jersey.demo;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Matrix parameters are a set of “name=value” in URI path, for example,
 * 
 * /books/2011;author=mkyong
 * 
 * separate by a semi colon “;“
 * 
 * Try:“/books/2011;country=malaysia;author=mkyong”
 * 
 * @author Administrator
 *
 */
@Path("/books")
public class BookService {

	@GET
	@Path("{year}")
	public Response getBooks(@PathParam("year") String year,
			@MatrixParam("author") String author,
			@MatrixParam("country") String country) {

		return Response
				.status(200)
				.entity("getBooks is called, year : " + year + ", author : "
						+ author + ", country : " + country).build();

	}

}
