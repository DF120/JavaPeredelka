package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;

public interface TheaterRepository extends JpaRepository<Theater, Long>{
    @Query("SELECT p FROM Theater p WHERE CONCAT(p.performanceName, ' ', p.actorCollective, ' ', p.performanceDateTime,' ', p.totalTickets, ' ',p.availableTickets,' ') LIKE %?1%")
    List<Theater> search(String keyword);


}
