package com.resteasy.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
// set the path to REST web services
public class ApplicationConfig extends Application {

	 @SuppressWarnings("unchecked")
	    public Set<Class<?>> getClasses() {
	        return new HashSet<Class<?>>(Arrays.asList(AppRestService.class));
	    }
}
