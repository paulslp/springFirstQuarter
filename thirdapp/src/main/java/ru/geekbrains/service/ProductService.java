package ru.geekbrains.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.domain.Product;
import ru.geekbrains.repository.ProductDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productRepository;

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> findAll(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest).getContent();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
