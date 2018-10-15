/**
 * 
 *//*
package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.User;
import com.learning.service.IUserService;

*//**
 * @author Sumit kumar
 *
 *//*

@RestController
@RequestMapping("/rest/userRegistration")
public class RegistrationController {
	@Autowired
	private IUserService userService;
	
	@PostMapping("register")
	public ResponseEntity<Void> registerUserAccount(@RequestBody User newUser){
		userService.addUser(newUser);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
}
*/