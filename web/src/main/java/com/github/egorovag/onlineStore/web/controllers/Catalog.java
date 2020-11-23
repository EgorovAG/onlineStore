package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.model.enums.ProductName;
import com.github.egorovag.onlineStore.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    private ProductService productService;

    public Catalog(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String getProductByName(@RequestParam(value = "productName") String productName, Model model) {
        List<Product> products = productService.getProductByProductNameService(ProductName.valueOf(productName));
        if (products == null || products.isEmpty()) {
            model.addAttribute("products", null);
        } else {
            model.addAttribute("products", products);
        }
        return "catalog";
    }

    @GetMapping("/view")
    public String getProductById(@RequestParam(value = "view") Long id, Model model) {
        Product product = productService.getProductByIDService(id);
        if (product.equals(null)) {
            model.addAttribute("product", null);
        } else {
            model.addAttribute("product", product);
        }
        return "productView";
    }

    @PostMapping("/order")
    public String setProductById(@RequestParam(value = "order") Long id, Model model) {
        Product product = productService.setProductByIDService(id);
        if (product.equals(null)) {
            model.addAttribute("product", null);
        } else {
            model.addAttribute("product", product);
        }
        return "productView";
    }


}
