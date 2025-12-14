package com.smart.instagram.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.instagram.model.User;
import com.smart.instagram.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	 private final UserRepository userRepository;
	    private final BCryptPasswordEncoder passwordEncoder;

	    public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	        this.passwordEncoder = new BCryptPasswordEncoder();
	    }
	    
	    
	@Override
	public User registerUser(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
	
		 return userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	}
	
	

}
