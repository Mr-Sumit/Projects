/*package com.learning.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint{

	public void commence(HttpServletRequest request, HttpServletResponse response, 
			AuthenticationException authEx) throws IOException, ServletException {
		response.addHeader("WWW-Authenticate", "Basic realm="+getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter pw = response.getWriter();
		pw.println("Http Status 401 - "+authEx.getMessage());
	}
	
	public void afterPropertiesSet() throws Exception{
		setRealmName("Realm");
		super.afterPropertiesSet();
	}
}
*/