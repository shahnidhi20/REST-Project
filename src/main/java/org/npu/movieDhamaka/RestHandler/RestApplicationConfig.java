package org.npu.movieDhamaka.RestHandler;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;





/*   See web.xml file for Jersey configuration  */
/*   Need to register classes with @PATH annotations and other JAX-RS components */
@ApplicationPath("/")
public class RestApplicationConfig extends Application {
	private Set<Class<?>> restClassSet = new HashSet<Class<?>>();
	
	public RestApplicationConfig() {
		System.out.println("Loaded REST Config");
		restClassSet.add(JacksonFeature.class);
		restClassSet.add(MovieRestHandler.class);
		//restClassSet.add(UnknownResourceExResolver.class);
	}
	
	public Set<Class<?>> getClasses() {
		return restClassSet;
	}
}
