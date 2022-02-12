package ru.geekbrains.repository;

import ru.geekbrains.domain.Product;

public interface ProductDao {
    Iterable<Product> findAll();

    Product findById(Long id);

    String findNameById(Long id);

    void insert(Product manufacturer);

    void deleteById(Long id);
}
