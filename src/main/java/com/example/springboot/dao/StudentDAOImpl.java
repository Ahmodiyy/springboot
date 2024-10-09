package com.example.springboot.dao;

import com.example.springboot.entity.Students;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Component
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    //@Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Students theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Students findById(Integer id) {
        return  entityManager.find(Students.class, id);
    }

    @Override
    public List<Students> findAll() {
        return entityManager.createQuery("FROM Students WHERE lastName = \"Lina\"", Students.class).getResultList();
    }

    @Override
    @Transactional
    public void update(Students students) {
        entityManager.merge(students);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Students students = entityManager.find(Students.class, id);
        entityManager.remove(students);
    }
}
