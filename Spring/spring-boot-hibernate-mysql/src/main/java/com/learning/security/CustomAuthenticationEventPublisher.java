package com.learning.security;

import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationEventPublisher implements AuthenticationEventPublisher{

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		System.out.println("Inside Success" + authentication.isAuthenticated() + " "+ authentication.getPrincipal());
		
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		System.out.println("Inside failure" +authentication.isAuthenticated() + " "+ authentication.getPrincipal());
		
	}
	

}
