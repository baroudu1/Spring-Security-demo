package com.example.demo.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="role") @Data @NoArgsConstructor @AllArgsConstructor @Table
public class Role {
    @Id
    @SequenceGenerator(
            name = "sequence_role",
            sequenceName = "sequence_role",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_role"
    )
    private Long id;
    private String name;
}
