package com.learning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.learning.security.CustomAuthenticationEventPublisher;
import com.learning.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService userDetailsService; 
	
	@Bean
 	public PasswordEncoder passwordEncoder(){
 		return new BCryptPasswordEncoder();
 	}
	
	@Bean
 	public DaoAuthenticationProvider authenticationProvider(){
 		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
 		authenticationProvider.setUserDetailsService(userDetailsService);
 		authenticationProvider.setPasswordEncoder(passwordEncoder());
 		return authenticationProvider;
 	}
	
	@Override
 	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/user/add").permitAll()
			.antMatchers("/user/*").hasRole("USER").and().httpBasic();
 	}

 	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth.authenticationProvider(authenticationProvider());
 		auth.authenticationEventPublisher(new CustomAuthenticationEventPublisher());
 	}
}
