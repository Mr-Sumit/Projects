package com.learning.service;

import java.util.List;

import com.learning.exception.ResourceNotFoundException;
import com.learning.exception.UsernameFoundException;
import com.learning.exception.UsernameNotFoundException;
import com.learning.model.User;

public interface IUserService {
	public boolean addUser(User newUser) throws UsernameFoundException;

	public User getUserById(int id);
	
	public boolean deleteUserById(int id);
	
	public abstract boolean updateUser(User user) throws ResourceNotFoundException;
	
	public abstract List<User> getAllUser();
	
	public User getUserByEmail(String email) throws UsernameNotFoundException;
}
