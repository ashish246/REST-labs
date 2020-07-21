package com.resteasy.demo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//It's good practice to include a version number in the path so you can have
//multiple versions deployed at once. That way consumers don't need to upgrade
//right away if things are working for them.
@Path("calc/1.0")
public class CalculatorV1_0 {
	@GET
	@Consumes("text/plain")
	@Produces("text/plain")
	@Path("addTwoNumbers")
	public String add(@MatrixParam("firstNumber") int n1,
			@MatrixParam("secondNumber") int n2) {
		return String.valueOf(n1 + n2);
	}
}
