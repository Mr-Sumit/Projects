/**
 * 
 */
package com.learning.security;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.model.User;
import com.learning.repository.IUserRepository;

/**
 * @author Sumit Kumar
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserRepository<User> userRepository;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(null == user){
			throw new UsernameNotFoundException("No User Found with Email : " + email);
		}
		
		return new org.springframework.security.core.userdetails.User
				(user.getEmail(), user.getPassword(), true, true, true, true, getAuthorities());
		}
	
	private static List<GrantedAuthority> getAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<>();
		//for(String role: roles){
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		//}
		return authorities;
	}
}
