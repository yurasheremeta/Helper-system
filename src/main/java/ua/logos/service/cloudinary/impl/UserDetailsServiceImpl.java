package ua.logos.service.cloudinary.impl;

import org.springframework.stereotype.Service;

import ua.logos.entity.UserEntity;
import ua.logos.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
    private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = repository.findByUsername(username);
		if(userEntity == null) {
			throw new UsernameNotFoundException("User with username '"+username+"' not found");
		}
		return User.builder()
				.username(userEntity.getUsername())
				.password(userEntity.getPassword())
				.authorities(userEntity.getRole())
				.build();
	}
	
	
	

}
