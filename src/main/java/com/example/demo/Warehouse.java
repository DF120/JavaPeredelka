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
    private String equipment_name;
    private String equipment_group;
    private String issueCity;
    private String arrivalCity;
    private LocalDate issueDate;
    private LocalDate arrivalDate;

    protected Warehouse() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "warehouse [id=" + id + ", equipment_name=" + equipment_name + ", equipment_group=" + equipment_group + ", issueCity=" + issueCity + ", arrivalCity=" + arrivalCity+ ", issueDate=" + issueDate + ", arrivalDate=" + arrivalDate + "]";
    }
}