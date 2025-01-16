package com.pepinho.ad.biblioteca.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JPABookDAO implements DAO<Book> {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("bibliotecaPostgres");

    private EntityManager entityManager;

    public JPABookDAO(EntityManager entityManager){
        this.entityManager= entityManager;
    }

    @Override
    public Book get(long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        return entityManager.createQuery("SELECT ")
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public List<Long> getAllIds() {
        return List.of();
    }

    @Override
    public void updateLOB(Book book, String f) {

    }

    @Override
    public void updateLOBById(long id, String f) {

    }

    @Override
    public void deleteAll() {

    }
}
