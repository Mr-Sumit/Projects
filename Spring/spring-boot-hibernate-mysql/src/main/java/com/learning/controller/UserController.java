package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.User;
import com.learning.service.IUserService;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = {"http://localhost:8080"}, maxAge = 3000, allowedHeaders="header1", exposedHeaders="header1", allowCredentials="false")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@PostMapping("add")
	public ResponseEntity<Void> createUser(@RequestBody User user){
		userService.addUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("load/{id}")
	//@CrossOrigin(origins="http://localhost:8080", exposedHeaders="testHeader")
	public ResponseEntity<User> getUser(@PathVariable int id){
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> userList = userService.getAllUser();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deteteUser(@PathVariable int id){
		boolean result = userService.deleteUserById(id);
		return result == true ? new ResponseEntity<Void>(HttpStatus.NO_CONTENT):new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("update")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		userService.updateUser(user);	
		return new ResponseEntity<String>("Update Successfull",HttpStatus.OK);
	}
}