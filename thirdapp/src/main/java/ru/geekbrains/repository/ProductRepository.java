package ru.geekbrains.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.geekbrains.domain.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class ProductRepository {

    private List<Product> storage;

    @PostConstruct
    private void populate() {
        List<Product> storage = new ArrayList<>();
        storage.add(new Product(1, "milk", 34.54));
        storage.add(new Product(2, "butter", 140));
        storage.add(new Product(3, "meat", 500));
        storage.add(new Product(4, "wine", 700));
        storage.add(new Product(5, "carrot", 49.90));
        setStorage(storage);
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
