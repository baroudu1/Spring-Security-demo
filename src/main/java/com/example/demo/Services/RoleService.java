package com.example.demo.Services;

import com.example.demo.Models.Role;
import com.example.demo.Repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @AllArgsConstructor @Transactional @Slf4j
public class RoleService implements RoleInterface{
    private final RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        log.info("Saving a new role into database");
        return roleRepository.save(role);
    }

    @Override
    public Role getRole(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
}
