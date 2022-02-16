package ru.geekbrains.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.domain.Product;
import ru.geekbrains.service.ProductService;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private static final String PRODUCTS_JSP_NAME = "products";

    private static final String PRODUCTS_ATTRIBUTE_NAME = "products";

    private static final String PRODUCT_ATTRIBUTE_NAME = "product";

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        log.info("getAllProducts executing ...");
        PageRequest pageRequest = constructPageRequest(0, 10, "id_asc");
        model.addAttribute(PRODUCTS_ATTRIBUTE_NAME, productService.findAll(pageRequest));
        return PRODUCTS_JSP_NAME;
    }

    @PostMapping("/products")
    public String getPageProducts(Model model,
                                  @RequestParam int page,
                                  @RequestParam int size,
                                  @RequestParam String sort) {
        log.info("getPageProducts executing ...");
        PageRequest pageRequest = constructPageRequest(page, size, sort);
        model.addAttribute(PRODUCTS_ATTRIBUTE_NAME, productService.findAll(pageRequest));
        return PRODUCTS_JSP_NAME;
    }

    @GetMapping("/product")
    public String getProductById(Model model, @RequestParam Long id) {
        log.info("getAllProducts executing ...");
        model.addAttribute(PRODUCTS_ATTRIBUTE_NAME, List.of(productService.findById(id)));
        return PRODUCTS_JSP_NAME;
    }

    @GetMapping("/products/add")
    public String showAddingForm(Model model) {
        log.info("showAddingForm executing ...");
        model.addAttribute(PRODUCT_ATTRIBUTE_NAME, new Product());
        model.addAttribute("actionType", "Add");
        return "save-product";
    }

    @PostMapping("/products/edit")
    public String showUpdatingForm(Model model, @RequestParam Long id) {
        log.info("showUpdatingForm executing ...");
        model.addAttribute(PRODUCT_ATTRIBUTE_NAME, productService.findById(id));
        model.addAttribute("actionType", "Edit");
        return "save-product";
    }

    @GetMapping("/products/delete")
    public String showDeletingForm(Model model) {
        log.info("showDeletingForm executing ...");
        model.addAttribute(PRODUCT_ATTRIBUTE_NAME, new Product());
        model.addAttribute(PRODUCTS_ATTRIBUTE_NAME, productService.findAll());
        return "delete-product";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product) {
        log.info("saveProduct executing ...");
        productService.save(product);
        return "redirect:/products";
    }

    @PostMapping("/products/delete")
    public String deleteProduct(@RequestParam Long id) {
        log.info("deleteProduct executing ...");
        productService.deleteById(id);
        return "redirect:/products";
    }

    private PageRequest constructPageRequest(int page, int size, String sort) {
        Sort.Direction direction = sort.endsWith("asc") ? ASC : DESC;
        String property = sort.substring(0, sort.lastIndexOf("_"));
        return PageRequest.of(
                page, size, Sort.by(List.of(new Sort.Order(direction, property)))
        );
    }
}
