package com.example.demo.Controllers;

import com.example.demo.Models.Role;
import com.example.demo.Services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("api/v1/role") @RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    @GetMapping
    public ResponseEntity<List<Role>> getAllRole(){
        return ResponseEntity.ok().body(roleService.getAllRole());
    }
    @PostMapping("/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.ok().body(roleService.saveRole(role));
    }
}
