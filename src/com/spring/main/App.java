package com.spring.main;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class App extends AbstractAnnotationConfigDispatcherServletInitializer {
static {
	System.out.println("App Initializers called...");
}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("getRootConfigClasses caleed...");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfigClasses called");
		Class<?>[] classes=new Class[] {ServletConfig.class};
		return classes;
		
		
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		//System.out.println("getServletMappings  called");
		String[] mappings=new String[] {"/"};
		
		return mappings;
	}
	
	
	
	
}


