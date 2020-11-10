package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class Catalog {
    private static final Logger log = LoggerFactory.getLogger(Catalog.class);
    ProductService productService;
    Product product = new Product(1, "qwe", "asd", 10, 5);

    @PostMapping("/product")
    public String getProduct(Model model) throws IOException {
//        List<Product> products = productService.getProductByNameService();
//        if (products == null || products.isEmpty()) {
//            model.addAttribute("products", null);
//        } else {
//            model.addAttribute("products", products);
//        }
        List<Product> products = new ArrayList<>();
        System.out.println(product.getDescription());
        model.addAttribute("products", products);
        return "catalog";
    }
}
