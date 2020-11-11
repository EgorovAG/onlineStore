package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class Catalog {
    private static final Logger log = LoggerFactory.getLogger(Catalog.class);
    ProductService productService;

    @PostMapping("/product")
    public String getProduct(@RequestParam(value = "product") String product , Model model) {
        List<Product> products = productService.getProductByNameService(product);
        if (products == null || products.isEmpty()) {
            model.addAttribute("products", null);
        } else {
            model.addAttribute("products", products);
        }
        return "catalog";
    }
}
