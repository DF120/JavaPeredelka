package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KonfRepository extends JpaRepository<Konf, Long>{
    @Query("SELECT p FROM Konf p WHERE CONCAT(p.konfName, ' ', p.konfDate, ' ', p.s_name, ' ', p.speaker_name, ' ') LIKE %?1%")
    List<Konf> search(String keyword);
}
