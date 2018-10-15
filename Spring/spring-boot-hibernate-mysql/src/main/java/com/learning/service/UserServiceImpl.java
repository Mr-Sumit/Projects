package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.exception.ResourceNotFoundException;
import com.learning.exception.UsernameFoundException;
import com.learning.exception.UsernameNotFoundException;
import com.learning.model.User;
import com.learning.repository.IUserRepository;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository<User> userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean addUser(User newUser) throws UsernameFoundException{
		User user = userRepository.findByEmail(newUser.getEmail());
		if(null != user){
			throw new UsernameFoundException();
		}
		String encodePassword = passwordEncoder.encode(newUser.getPassword());
		newUser.setPassword(encodePassword);
		userRepository.save(newUser);
		return true;
	}

	@Override
	public User getUserById(int id) {
		User user = userRepository.loadById(id);
		return user;
	}

	@Override
	public boolean deleteUserById(int id) {
		return userRepository.deleteById(id);
	}

	@Override
	public boolean updateUser(User user) {
		if(userRepository.update(user) != null){
			return true;
		}else{
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public List<User> getAllUser() {
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		if(null == user){
			throw new UsernameNotFoundException();
		}
		return user;
	}
	
}