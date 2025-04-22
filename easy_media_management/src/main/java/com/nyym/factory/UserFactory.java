package com.nyym.factory;

import com.nyym.entites.User;

public interface UserFactory {
    User createUser(String name, String surname, String email, String password, String phone, String gender);
}
