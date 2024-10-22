package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Setter;
import lombok.Getter;


@Setter
@Getter
@Entity

public class Barber {
    private Long id;
    private String surNm;
    private LocalDateTime vrema;
    private String usluga;
    private String masterName;

    protected Barber() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    @Override
    public String toString() {return "barber [id=" + id + ", surNm=" + surNm  + ", vrema=" + vrema + ", usluga=" + usluga + ", masterName=" + masterName +"]";}
}
