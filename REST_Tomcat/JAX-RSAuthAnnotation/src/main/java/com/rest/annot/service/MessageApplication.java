package com.rest.annot.service;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class MessageApplication extends ResourceConfig {
	// private Set<Object> singletons = new HashSet<Object>();

	public MessageApplication() {
		
		super(AppRestService.class);

		register(RolesAllowedDynamicFeature.class);
	}

}
