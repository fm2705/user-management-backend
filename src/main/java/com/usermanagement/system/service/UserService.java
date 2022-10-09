package com.usermanagement.system.service;

import com.usermanagement.system.model.User;

import java.util.List;


public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();


}
