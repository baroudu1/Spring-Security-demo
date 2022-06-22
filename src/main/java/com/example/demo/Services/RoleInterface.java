package com.example.demo.Services;

import com.example.demo.Models.Role;

import java.util.List;

public interface RoleInterface {
    Role saveRole(Role role);
    Role getRole(String roleName);
    List<Role> getAllRole();
}
