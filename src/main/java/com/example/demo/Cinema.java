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
public class Cinema {
    private Long id;
    private String filmName;
    private String filmStudio;
    private LocalDate issueDate;
    private String tikets;

    protected Cinema() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "auto [id=" + id + ", filmName=" + filmName + ", filmStudio=" + filmStudio + ", issueDate=" + issueDate + ", tikets=" + tikets + "]";
    }
}
