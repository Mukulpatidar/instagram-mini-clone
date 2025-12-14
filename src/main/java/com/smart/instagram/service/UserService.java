package com.smart.instagram.service;

import java.util.Optional;

import com.smart.instagram.model.User;

public interface UserService {

	 User registerUser(User user);

	    Optional<User> findByUsername(String username);

	    User findById(Long id);
}
