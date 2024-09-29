package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CinemaRepository extends JpaRepository<Cinema, Long>{
    @Query("SELECT p FROM Cinema p WHERE CONCAT(p.filmName, ' ', p.filmStudio, ' ', p.issueDate, p.tikets, ' ') LIKE %?1%")
    List<Cinema> search(String keyword);
}
