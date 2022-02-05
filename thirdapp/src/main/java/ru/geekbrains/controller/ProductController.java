package ru.geekbrains.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.domain.Product;
import ru.geekbrains.service.ProductService;

@Controller
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getAllProducts(Model model) {
        log.info("getAllProducts executing ...");
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/add")
    public String showAddingForm(Model model) {
        log.info("showAddingForm executing ...");
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(Model model, Product product) {
        log.info("addProduct executing ...");
        productService.add(product);
        return getAllProducts(model);
    }
}
