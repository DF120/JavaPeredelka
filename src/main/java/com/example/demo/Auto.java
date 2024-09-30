package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Setter;
import lombok.Getter;


@Setter
@Getter
@Entity
public class Auto {
    private Long id;
    private String stamp;
    private String name;
    private LocalDate issueDate;
    private LocalDate returnDate;

    protected Auto() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }



    @Override
    public String toString() {
        return "auto [id=" + id + ", stamp=" + stamp + ", name=" + name + ", issueDate=" + issueDate + ", returnDate=" + returnDate + "]";
    }
}