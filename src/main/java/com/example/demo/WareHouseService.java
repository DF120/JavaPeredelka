package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WareHouseService {
    @Autowired
    private WareHouseRepository repo;

    public List<WareHouse> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(WareHouse wareHouse) {
        repo.save(wareHouse);
    }
    public WareHouse get(Long id) {
        return repo.findById(id).get();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
