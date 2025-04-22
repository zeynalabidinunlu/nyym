package com.nyym.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyym.entites.User;
import com.nyym.factory.UserFactory;
import com.nyym.factory.impl.AdminUserFactory;
import com.nyym.factory.impl.EditorUserFactory;
import com.nyym.repository.UserRepository;
import com.nyym.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private UserFactory selectFactoryByRole(String role) {
        return switch (role) {
            case "admin" -> new AdminUserFactory();
         //   case "user" -> new UserFactory();
            case "editor" -> new EditorUserFactory(); 
            default -> throw new IllegalArgumentException("Unsupported role: " + role);
        };
    }


    @Override
    public User saveUser(User user) {
    	
        UserFactory factory = selectFactoryByRole(user.getRole());

        User createdUser = factory.createUser(
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone(),
                user.getGender()
        );

        return userRepository.save(createdUser);
    }
}
