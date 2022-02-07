package ru.geekbrains.config.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.domain.Product;

import java.util.List;

@Configuration
@ConfigurationProperties("product.properties")
@Getter
@Setter
public class ProductProperties {

    List<Product> products;
}
