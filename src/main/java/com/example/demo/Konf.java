package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Konf {
    private Long id;
    private String konfName;
    private String s_name;
    private String speaker_name;
    private LocalDate konfDate;

    protected Konf() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "konf [id=" + id + ", konfName=" + konfName + ", konfDate=" + konfDate + ", s_name=" + s_name + ", speaker_name=" + speaker_name  + "]";
    }
}
