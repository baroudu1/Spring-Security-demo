package com.example.demo.Configurations;

import com.example.demo.Models.Role;
import com.example.demo.Repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoleConfiguration {
    @Bean
    CommandLineRunner roleCommandLineRunner (RoleRepository roleRepository){
        return args -> {
            Role r1 = new Role();
            r1.setName("R1");
            Role r2 = new Role();
            r2.setName("R2");
            roleRepository.saveAll(
                    List.of(
                            r1,r2
                    )
            );
        };
    }
}