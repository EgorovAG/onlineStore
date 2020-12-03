package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.Cart;
import com.github.egorovag.onlineStore.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class Start {

    @GetMapping("/")
    public String doGet(HttpSession httpSession) {
        List<Product> listProductsInTheCart = new ArrayList<>();
        httpSession.setAttribute("productsInTheCart", listProductsInTheCart);
        return "index";
    }
}
