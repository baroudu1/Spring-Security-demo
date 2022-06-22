package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user") @RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }
    @PostMapping("/addRole")
    public ResponseEntity<?> addRoleToUser(@RequestBody AddRoleToUser addRoleToUser){
        userService.addRoleToUser(addRoleToUser.getUserName(),addRoleToUser.getRoleName());
        return ResponseEntity.ok().build();
    }
    @Data
    class AddRoleToUser{
        private String userName;
        private String roleName;
    }

}
