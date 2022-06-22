package com.example.demo.Services;

import com.example.demo.Models.Role;
import com.example.demo.Models.User;

import java.util.List;

public interface UserInterface {
    User saveUser(User user);
    void addRoleToUser(String userName, String roleName);
    User getUser(String username);
    List<User> getAllUsers();
    Role getRole(String roleName);
}
