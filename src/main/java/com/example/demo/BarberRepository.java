package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BarberRepository extends JpaRepository<Barber, Long>{
    @Query("SELECT p FROM Barber p WHERE CONCAT(p.surNm, ' ', p.vrema, ' ', p.usluga,' ', p.masterName, ' ') LIKE %?1%")
    List<Barber> search(String keyword);


}
