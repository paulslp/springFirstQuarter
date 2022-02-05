package ru.geekbrains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope("prototype")
@Getter
@AllArgsConstructor
public class Cart {

    private final Map<Integer, Integer> productsMap;

    public void add(int productId) {
        int productCount = (productsMap.containsKey(productId)) ? productsMap.get(productId) + 1 : 1;
        productsMap.put(productId, productCount);
    }

    public void remove(int productId) {
        if (productsMap.containsKey(productId)) {
            int productCount = productsMap.get(productId);
            if (productCount == 1) {
                productsMap.remove(productId);
            } else {
                productsMap.put(productId, productCount - 1);
            }
        } else {
            System.out.println("ProductId = " + productId + " not found in cart. Removing has been canceled");
        }
    }

    public void print() {
        for (Map.Entry<Integer, Integer> element : productsMap.entrySet()) {
            System.out.println("productId= " + element.getKey() + ", count = " + element.getValue());
        }
        System.out.println("Cart size = " + productsMap.size());
        System.out.println("----------end printing-------");
    }
}
