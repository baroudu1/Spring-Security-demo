package com.example.demo.Services;


import com.example.demo.Models.Role;
import com.example.demo.Models.User;
import com.example.demo.Repositories.RoleRepository;
import com.example.demo.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @AllArgsConstructor @Transactional @Slf4j
public class UserService implements UserInterface , UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
        log.info("Saving a new user into database");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userRepository.findUserByUsername(userName);
        Role role = roleRepository.findRoleByName(roleName);
        List<Role> roles = user.getRoles();
        roles.add(role);
        user.setRoles(roles);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Role getRole(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null){
            log.info("User not founded");
            throw new IllegalArgumentException("User not founded");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = user.getRoles();
        for ( Role role:roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        System.err.println(user.toString());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
