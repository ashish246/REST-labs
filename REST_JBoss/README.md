##Registering REST Resources/Providors with the application##

### RESTEasy ###
-------------------------------------------------------------
#####RESTEasyExample1#####

- Turn on the scanner: `resteasy.scan=true`
- Define a listner (Deprecated in Servlet 3.0): `org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap`
- Define a servlet: `org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher`


#####RESTEasyExample2#####
- Subclass of `javax.ws.rs.core.Application` was defined without annotation of `@ApplicationPath`
- Resource is registered in Application-subclass
- Application-subclass is initialized with the servlet: `org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher`
- No listner is used


#####RESTEasyWithApp#####
- No `Application` subclass is defined.
- No listner is defined
- `javax.ws.rs.core.Application` is defined as servlet in `web.xml`


#####RESTEasyWithAppAnnot#####
- `web.xml` is empty
- Subclass of `javax.ws.rs.core.Application` was defined with the annotation of `@ApplicationPath`
- Resource is registered in the Application-subclass  



### Jeresy ###
----------------------------------------------------------------
#####JeresyRestExample1#####
- Initialize the resource package in servlet: `com.sun.jersey.spi.container.servlet.ServletContainer`

#####JeresyRestExample2#####
- Subclass of `javax.ws.rs.core.Application` was defined without annotation of `@ApplicationPath`
- Resource is registered in Application-subclass
- Application-subclass is initialized with the servlet: `com.sun.jersey.spi.container.servlet.ServletContainer`

#####JeresyRestWithApp#####
- No `Application` subclass is defined.
- No listner is defined
- `javax.ws.rs.core.Application` is defined as servlet in `web.xml`

#####JerseyRestWithAppAnnot#####
- `web.xml` is empty
- Subclass of `javax.ws.rs.core.Application` was defined with the annotation of `@ApplicationPath`
- Resource is registered in the Application-subclass


-------------------------------------------------------------------