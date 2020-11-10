package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class Catalog {
    private static final Logger log = LoggerFactory.getLogger(Catalog.class);
    ProductService productService;

    @GetMapping("/product")
    public String getProduct(HttpRequest rq, Model model) {
        List<Product> products = productService.getProductByNameService();
        if (products == null || products.isEmpty()) {
            model.addAttribute("products", null);
        } else {
            model.addAttribute("products", products);
        }
        return "catalog";
    }
}
