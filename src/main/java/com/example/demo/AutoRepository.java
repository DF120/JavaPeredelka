package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutoRepository  extends JpaRepository<Auto, Long>{
    @Query("SELECT p FROM Auto p WHERE CONCAT(p.stamp, ' ', p.name, ' ', p.issueDate, p.returnDate, ' ') LIKE %?1%")
    List<Auto> search(String keyword);
}
