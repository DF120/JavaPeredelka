package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KonfService {
    @Autowired
    private KonfRepository repo;

    public List<Konf> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(Konf konf) {
        repo.save(konf);
    }
    public Konf get(Long id) {
        return repo.findById(id).get();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
