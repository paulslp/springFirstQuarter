package ru.geekbrains.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.domain.Product;
import ru.geekbrains.repository.ProductDao;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void add(Product product) {
        productRepository.insert(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
