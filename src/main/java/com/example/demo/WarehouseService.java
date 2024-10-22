package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository repo;

    public List<Warehouse> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(Warehouse wareHouse) {
        repo.save(wareHouse);
    }
    public Warehouse get(Long id) {
        return repo.findById(id).get();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}