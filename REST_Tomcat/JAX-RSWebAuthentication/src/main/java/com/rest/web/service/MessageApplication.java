package com.rest.web.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class MessageApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public MessageApplication() {
		singletons.add(new AppRestService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
