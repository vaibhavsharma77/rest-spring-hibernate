package com.myapp.rest;

import java.util.HashSet;
import java.util.Set;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ApplicationPath("tme")
public class BaseUriResource extends Application {
	protected ApplicationContext springContext;
	@Context
	protected ServletContext servletContext;

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		addResources(resources);
		return resources;
	}

	private void addResources(Set<Class<?>> resources) {
		resources.add(com.myapp.rest.MyResource.class);

	}
	
	@Override
	public Set<Object> getSingletons() {
		try
	      {
	         InitialContext ctx = new InitialContext();
	         String xmlFile = (String)servletContext.getInitParameter
	                          ("contextConfigLocation");
	         springContext = new ClassPathXmlApplicationContext(xmlFile);
	      }
	      catch (Exception ex)
	      {
	         throw new RuntimeException(ex);
	      }
		HashSet<Object> set = new HashSet();
	      set.add(springContext.getBean("resources"));
	      return set;
	}
	
}