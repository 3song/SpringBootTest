package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
    List<User> getUserList();
    int addUser(User user);
}