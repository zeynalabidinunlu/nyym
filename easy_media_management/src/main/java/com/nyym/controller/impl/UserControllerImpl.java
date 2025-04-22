package com.nyym.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyym.controller.IUserController;
import com.nyym.entites.User;
import com.nyym.services.IUserService;

@RequestMapping("/rest/api/user")
@RestController
public class UserControllerImpl implements IUserController{
	
	@Autowired
	private IUserService userService;

	
	@PostMapping(path  = "/saveUser")
	@Override
	public User saveUser(@RequestBody User user) {
		
		return userService.saveUser(user);
	
	}

}