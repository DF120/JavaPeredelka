package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long>{
    @Query("SELECT p FROM Warehouse p WHERE CONCAT(p.equipment_name, ' ', p.equipment_group, ' ', p.issueCity, ' ', p.arrivalCity, p.issueDate, ' ', p.arrivalDate, ' ') LIKE %?1%")
    List<Warehouse> search(String keyword);
}
