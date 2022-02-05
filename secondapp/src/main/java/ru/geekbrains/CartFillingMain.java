package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.CartFillingConfig;
import ru.geekbrains.domain.Product;
import ru.geekbrains.repository.ProductRepository;

import java.util.Random;

public class CartFillingMain {

    private static int PRODUCT_COUNT = 5;

    private static int OPERATION_COUNT = 3;

    /*
    Задание
        1. Есть класс Product (id, название, цена). Товары хранятся в бине ProductRepository,
        в виде List<Product>, при старте в него нужно добавить 5 любых товаров.
        2. ProductRepository позволяет получить весь список или один товар по id.
        Создаем бин Cart, в который можно добавлять и удалять товары по id.
        3. Написать консольное приложение, позволяющее управлять корзиной.
        4. При каждом запросе корзины из контекста, должна создаваться новая корзина.
     */

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CartFillingConfig.class);

        ProductRepository repository = context.getBean(ProductRepository.class);

        for (int i = 0; i < PRODUCT_COUNT; i++) {
            fillingCart(context, repository, i);
        }
    }

    private static void fillingCart(ApplicationContext context, ProductRepository repository, int cartIndex) {
        Cart cart = context.getBean(Cart.class);
        System.out.println();
        System.out.println("Start filling cart with index = " + cartIndex);
        System.out.println("-----Print cart with index " + cartIndex + " before filling--------");
        cart.print();
        for (int j = 0; j < OPERATION_COUNT; j++) {
            addRandomProductToCart(repository, cart);
            removeRandomProductFromCart(repository, cart);
        }
        System.out.println("-----Print cart with index " + cartIndex + " after filling-----");
        cart.print();
    }

    private static void addRandomProductToCart(ProductRepository repository, Cart cart) {
        Product product = repository.findById(new Random().nextInt(PRODUCT_COUNT));
        System.out.println("Add product: " + product);
        cart.add(product.getId());

    }

    private static void removeRandomProductFromCart(ProductRepository repository, Cart cart) {
        Product product = repository.findById(new Random().nextInt(PRODUCT_COUNT));
        System.out.println("Remove product: " + product);
        cart.remove(product.getId());
    }
}
