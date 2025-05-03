package com.nyym.factory.impl;

import com.nyym.entites.User;
import com.nyym.factory.UserFactory;

public class AdminUserFactory implements UserFactory {

    @Override
    public User createUser(String name, String surname, String email, String password, String phone, String gender) {
        return new User(
            null, // UUID otomatik üretilecek
            name,
            surname,
            gender,
            phone,
            "ADMIN", // sabit rol
            email,
            password,
            null
        );
    }
}
