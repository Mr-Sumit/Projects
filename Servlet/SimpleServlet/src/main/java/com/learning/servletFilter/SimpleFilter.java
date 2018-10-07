package com.learning.servletFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleFilter implements Filter{
	private String className = null;
	public void init(FilterConfig config) throws ServletException{
		className = config.getFilterName();
		System.out.println("Config Parameter = "+ config.getInitParameter("Test-Param"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Remote Address = "+ request.getRemoteAddr());
		chain.doFilter(request, response);
	}
	
	public void destroy(){
		System.out.println(className + "has stopped");
	}

}
