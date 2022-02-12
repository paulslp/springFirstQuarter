package ru.geekbrains.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.domain.Product;
import ru.geekbrains.service.ProductService;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        log.info("getAllProducts executing ...");
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/product")
    public String getProductById(Model model, @RequestParam Long id) {
        log.info("getAllProducts executing ...");
        model.addAttribute("products", List.of(productService.findById(id)));
        return "products";
    }

    @GetMapping("/products/add")
    public String showAddingForm(Model model) {
        log.info("showAddingForm executing ...");
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @GetMapping("/products/delete")
    public String showDeletingForm(Model model) {
        log.info("showDeletingForm executing ...");
        model.addAttribute("product", new Product());
        model.addAttribute("products", productService.findAll());
        return "delete-product";
    }

    @PostMapping("/products/add")
    public String addProduct(Model model, Product product) {
        log.info("addProduct executing ...");
        productService.add(product);
        return getAllProducts(model);
    }

    @PostMapping("/products/delete")
    public String deleteProduct(Model model, @RequestParam Long id) {
        log.info("deleteProduct executing ...");
        productService.deleteById(id);
        return getAllProducts(model);
    }
}
