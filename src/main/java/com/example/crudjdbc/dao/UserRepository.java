package com.example.crudjdbc.dao;

import com.example.crudjdbc.entity.UserA;
import org.apache.catalina.User;

import java.util.List;

public interface UserRepository {
    UserA saveUser(UserA userA);
    UserA updatedUser(UserA userA);
    UserA getUserById(int id);
    String deletedById(int id);
    List<UserA> getAllUsers();
}
