package com.example.demo.Configurations;
import com.example.demo.Models.User;
import com.example.demo.Services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class UserConfiguration {
    @Bean
    CommandLineRunner userCommandLineRunner (UserService userService){
        return args -> {
            User hamza = new User();
            hamza.setUsername("baroudu");
            hamza.setName("hamza");
            hamza.setPassword("123");
            User sara = new User();
            sara.setUsername("sarsora");
            sara.setName("sara");
            sara.setPassword("321");
            userService.saveUser(hamza);
            userService.saveUser(sara);
            userService.addRoleToUser("baroudu","R1");
            userService.addRoleToUser("baroudu","R2");
            userService.addRoleToUser("sarsora","R2");
        };
    }
}
