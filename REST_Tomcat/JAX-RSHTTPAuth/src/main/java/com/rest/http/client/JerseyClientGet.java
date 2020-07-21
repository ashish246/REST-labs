package com.rest.http.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

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

			// ********Approach II: SSL*************//
			/*SslConfigurator sslConfig = SslConfigurator.newInstance()
					.keyStoreFile(
							"E:/Projects/My_Projects/Shared/TechStuff/AT/REST_Tomcat/JAX-RSOAuthProject/src/main/resources/my-release-key.keystore") // E:\Projects\My_Projects\Shared\TechStuff\AT\REST_Tomcat\JAX-RSOAuthProject\src\main\resources\my-release-key.keystore
					.keyPassword("172911989198");

			SSLContext sslContext = sslConfig.createSSLContext();
			Client client = ClientBuilder.newBuilder().sslContext(sslContext)
					.build();*/
			

			// ********Approach I: Filter*************//
			/*
			 * use HTTPBasicAuthFilter in versions older than Jersey 2.5. Later
			 * use org.glassfish.jersey.client.filter.HttpDigestAuthFilter
			 * instead.
			 * 
			 * Client client = Client.create(); client.addFilter(new
			 * HTTPBasicAuthFilter("ashish","17291729"));
			 */

			
			// ********Approach III: Feature*************//
			// To initialize the feature use static methods and builder of this
			// feature. Example of building the feature in Basic authentication
			// mode:
			
			Client client = ClientBuilder.newBuilder()
					.build();
			HttpAuthenticationFeature feature = HttpAuthenticationFeature
					.basic("ashish", "17291729");
			client.register(feature);

			
			// Example of building the feature in basic non-preemptive mode:
			/*
			 * HttpAuthenticationFeature feature = HttpAuthenticationFeature
			 * .basicBuilder().nonPreemptive() .credentials("ashish",
			 * "17291729").build();
			 */

			/*
			 * You can also build the feature without any default credentials:
			 * 
			 * HttpAuthenticationFeature feature =
			 * HttpAuthenticationFeature.basicBuilder().build();
			 * 
			 * In this case you need to supply username and password for each
			 * request using request properties:
			 * 
			 * Response response =
			 * client.target("http://localhost:8080/rest/homer/contact"
			 * ).request() .property(HTTP_AUTHENTICATION_BASIC_USERNAME,
			 * "homer") .property(HTTP_AUTHENTICATION_BASIC_PASSWORD,
			 * "p1swd745").get();
			 */

			WebTarget webResource = client
					.target("http://localhost:8080/JAX-RSHTTPAuth/rest/app/Ashish");
			// .resource("http://localhost:8080/JAX-RSOAuthProject/rest/app/Ashish");

			Response response = webResource.request().get();

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			Object output = response.getEntity();

			System.out.println("Output from Server .... \n");
			System.out.println(output.toString());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
