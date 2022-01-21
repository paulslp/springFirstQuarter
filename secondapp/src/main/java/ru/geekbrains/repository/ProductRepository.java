package ru.geekbrains.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import ru.geekbrains.domain.Product;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Repository
@Getter
@Setter
public class ProductRepository {

    private List<Product> storage;

    @PostConstruct
    private void populate() {
        setStorage(Arrays.asList(new Product(1, "milk", 34.54),
                new Product(2, "butter", 140),
                new Product(3, "meat", 500),
                new Product(4, "wine", 700),
                new Product(5, "carrot", 49.90)));
    }

    public Product findById(int productId) {
        return storage.get(productId);
    }

}
