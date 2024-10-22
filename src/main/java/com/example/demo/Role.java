package com.example.demo;

import jakarta.persistence.Entity;

import java.util.Set;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;


@Setter
@Getter
@Entity

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
