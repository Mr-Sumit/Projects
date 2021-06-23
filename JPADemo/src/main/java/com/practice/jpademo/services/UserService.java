package com.practice.jpademo.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.jpademo.dto.UserDTO;
import com.practice.jpademo.repos.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository userRepo;
	

	public List<UserDTO> getUsers() {
		List<UserDTO> users = new ArrayList<UserDTO>();
		ModelMapper modelMapper = new ModelMapper();
		
		userRepo.findAll().forEach(user -> {
			users.add(modelMapper.map(user, UserDTO.class));
		});
		
		return users;
		
	}

}
