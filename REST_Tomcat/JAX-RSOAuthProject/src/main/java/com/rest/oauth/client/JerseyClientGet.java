package com.rest.oauth.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Creating a SslContext can be more difficult as you might need to init
 * instance properly with the protocol, KeyStore, TrustStore, etc. Jersey offers
 * a utility SslConfigurator class that can be used to setup the SslContext. The
 * SslConfigurator can be configured based on standardized system properties for
 * SSL configuration, so for example you can configure the KeyStore file name
 * using a environment variable javax.net.ssl.keyStore and SslConfigurator will
 * use such a variable to setup the SslContext.
 * 
 * Note that you can also setup KeyStore and TrustStore directly on a
 * ClientBuilder instance without wrapping them into the SslContext. However, if
 * you setup a SslContext it will override any previously defined KeyStore and
 * TrustStore settings. ClientBuilder also offers a method for defining a custom
 * HostnameVerifier implementation.
 * 
 * @author Administrator
 *
 */
public class JerseyClientGet {

	public static void main(String[] args) {
		try {

			Client client = Client.create();

			// client.addFilter(new HTTPBasicAuthFilter("ashish", "17291729"));

			WebResource webResource = client
					.resource("http://localhost:8080/JAX-RSOAuthProject/rest/app/Ashish");

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
