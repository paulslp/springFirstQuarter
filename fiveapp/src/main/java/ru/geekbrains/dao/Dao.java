package ru.geekbrains.dao;

public interface Dao<T> {
    Iterable<T> findAll();

    T findById(Long id);

    String findNameById(Long id);

    void insert(T entity);

    void update(T entity);

    void deleteById(Long id);
}
