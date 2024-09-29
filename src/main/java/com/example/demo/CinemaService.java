package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository repo;

    public List<Cinema> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(Cinema cinema) {
        repo.save(cinema);
    }
    public Cinema get(Long id) {
        return repo.findById(id).get();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
