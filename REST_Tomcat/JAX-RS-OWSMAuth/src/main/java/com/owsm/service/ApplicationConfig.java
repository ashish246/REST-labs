package com.owsm.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Import following package: oracle.wsm.metadata.annotation
 * 
 * You can attach OWSM policies to RESTful web services and clients that are
 * built using Jersey 1.x JAX-RS RI only. RESTful web services and clients that
 * are built using Jersey 2.5 JAX-RS RI cannot be secured using OWSM policies in
 * this release.
 * 
 * You can attach policies programmatically to the JAX-RS Application class
 * only.
 * 
 * @author Administrator
 *
 */
@PolicySet(references = {
		@PolicyReference("oracle/wss_http_token_service_policy"),
		@PolicyReference(value = "oracle/binding_permission_authorization_policy", properties = {
				@Property(name = "resource", value = "com.owsm.service.ApplicationConfig"),
				@Property(name = "action", value = "") }) })
@ApplicationPath("/rest")
// set the path to REST web services
public class ApplicationConfig extends Application {

}
