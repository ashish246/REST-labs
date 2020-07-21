package com.jersey.demo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * This tutorial show you how to use Jersey client APIs to create a RESTful Java
 * client to perform “GET” and “POST” requests to REST service that created in
 * this “Jersey + Json” example JerseyWithJSON project.
 * 
 * @author Administrator
 *
 */
public class JerseyClientGet {

	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/JerseyWithJSON/rest/json/metallica/get");

			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
