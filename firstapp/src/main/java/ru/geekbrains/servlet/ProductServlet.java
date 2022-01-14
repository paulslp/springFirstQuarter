package ru.geekbrains.servlet;

import lombok.extern.slf4j.Slf4j;
import ru.geekbrains.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Start creating product list");
        req.setAttribute("products", getProducts());
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }

    private List<Product> getProducts() {
        return Arrays.asList(
                new Product(1, "milk", 53.34),
                new Product(2, "bread", 43.63),
                new Product(3, "sugar", 63.04),
                new Product(4, "salt", 23.68),
                new Product(5, "potatoes", 50),
                new Product(6, "wine", 550),
                new Product(7, "butter", 169.90),
                new Product(8, "chocolate", 120.00),
                new Product(9, "tea", 99.90),
                new Product(10, "cafe", 140.00)
        );
    }
}
