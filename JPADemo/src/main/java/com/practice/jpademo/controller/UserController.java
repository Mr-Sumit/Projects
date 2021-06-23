package com.practice.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.jpademo.dto.UserDTO;
import com.practice.jpademo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public List<UserDTO> getUsers(){
		return userService.getUsers();
	}
	
	
}
