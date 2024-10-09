package com.example.springboot.dao;

import com.example.springboot.entity.Students;

import java.util.List;

public interface StudentDAO {
    void save(Students theStudent);
    Students findById(Integer id);
    List<Students> findAll();
    void update(Students students);
    void delete(Integer id);
}

