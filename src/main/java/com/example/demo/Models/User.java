package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.*;

@Entity(name="user") @Data @NoArgsConstructor @AllArgsConstructor @Table
public class User {
    @Id
    @SequenceGenerator(
            name = "sequence_user",
            sequenceName = "sequence_user",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_user"
    )
    private Long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch= EAGER)
    private List<Role> roles;

}
