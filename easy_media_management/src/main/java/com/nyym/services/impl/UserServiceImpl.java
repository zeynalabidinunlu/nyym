package com.nyym.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyym.entites.User;
import com.nyym.repository.UserRepository;
import com.nyym.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {

		return userRepository.save(user);
	}

}
