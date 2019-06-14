package com.asol.security.services;

import java.util.List;

import com.asol.security.entity.User;

public interface UserService {

    void addUser(User user);
    void updateUser(User user);
    List<User> getAllUsers();
    void deleteUser(int id);
    //User findOne(String username);

    User getUser(int id);
}