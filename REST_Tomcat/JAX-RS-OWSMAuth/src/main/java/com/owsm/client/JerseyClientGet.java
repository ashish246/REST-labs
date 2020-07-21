package com.owsm.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * You can attach OWSM policies to RESTful web services and clients that are
 * built using Jersey 1.x JAX-RS RI only. RESTful web services and clients that
 * are built using Jersey 2.5 JAX-RS RI cannot be secured using OWSM policies in
 * this release.
 * 
 * ou can programmatically attach OWSM security policies to RESTful web service
 * clients using the Feature classes defined in Table 4-1. The classes are
 * provided in the oracle.wsm.metadata.feature package.
 * 
 * When you create a RESTful client instance, optionally you can pass client
 * configuration properties by defining a
 * com.sun.jersey.api.client.config.ClientConfig and passing the information to
 * the create method of the weblogic.jaxrs.api.client.Client class.
 * 
 * Using the ClientConfig, you can attach OWSM policies and override
 * configuration properties, as shown in the following example. The following
 * code attaches the oracle/wss_http_token_client_policy policy to the client,
 * and overrides the CO_CSF_KEY configuration property with the value
 * weblogic-csf-key.
 * 
 * @author Administrator
 *
 */
public class JerseyClientGet {

	public static void main(String[] args) {
		try {

			ClientConfig cc = new DefaultClientConfig();
			cc.getProperties()
					.put(AbstractPolicyFeature.ABSTRACT_POLICY_FEATURE,
							new PolicySetFeature(
									new PolicyReferenceFeature(
											("oracle/wss_http_token_client_policy"),
											new PropertyFeature(
													SecurityConstants.ConfigOverride.CO_CSF_KEY,
													"weblogic-csf-key"))));
			Client client = Client.create(cc);

			WebResource webResource = client
					.resource("http://localhost:8080/JAX-RS-OWSMAuth/rest/app/Ashish");

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
