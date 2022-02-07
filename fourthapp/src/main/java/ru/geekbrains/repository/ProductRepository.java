package ru.geekbrains.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.geekbrains.config.properties.ProductProperties;
import ru.geekbrains.domain.Product;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
@Getter
@Setter
public class ProductRepository {

    private final ProductProperties productProperties;

    private List<Product> storage;

    @PostConstruct
    private void populate() {
        storage = productProperties.getProducts();
    }

    public Product findById(int productId) {
        return storage.get(productId);
    }

    public List<Product> findAll() {
        return storage;
    }

    public void add(Product product) {
        product.setId(storage.size());
        storage.add(product);
    }
}
