package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.LocalDate;
@Service
public class TheaterService {
    @Autowired
    private TheaterRepository repo;

    public List<Theater> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(Theater theater) {
        repo.save(theater);
    }
    public Theater get(Long id) {
        return repo.findById(id).get();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public int countByDate(LocalDateTime dateTime) {LocalDate date = dateTime.toLocalDate();return repo.countByDate(dateTime);}
}
