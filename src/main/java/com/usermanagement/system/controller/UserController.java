package com.usermanagement.system.controller;

import com.usermanagement.system.model.User;
import com.usermanagement.system.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
    //inject UserService
    private final UserService userService;

    public UserController(UserService userService) {
         this.userService = userService;
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}

