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
public class Warehouse {
    private Long id;
    private String equipment_type;
    private String equipment_group;
    private String name;
    private LocalDate issueDate;
    private LocalDate returnDate;

    protected Warehouse() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "warehouse [id=" + id + ", equipment_type=" + equipment_type + ", equipment_group=" + equipment_group + ", name=" + name + ", issueDate=" + issueDate + ", returnDate=" + returnDate + "]";
    }
}