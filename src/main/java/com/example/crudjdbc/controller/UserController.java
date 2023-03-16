package com.example.crudjdbc.controller;

import com.example.crudjdbc.dao.UserRepository;
import com.example.crudjdbc.entity.UserA;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public UserA addUser(@RequestBody UserA userA) {
        return userRepository.saveUser(userA);
    }

    @PutMapping("/user")
    public UserA updateUser(@RequestBody UserA userA) {
        return userRepository.updatedUser(userA);
    }

    @GetMapping("/user/{id}")
    public UserA getUserById(@PathVariable int id) {
        return userRepository.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserA> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        return userRepository.deletedById(id);
    }
}
