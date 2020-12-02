package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.Cart;
import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Set;


@Controller
@RequestMapping("/cart")
public class CartController {
    private static final Logger log = LoggerFactory.getLogger(CartController.class);
    private CartService cartService;
    private Product product;

    @GetMapping()
    public String goToCart(Model model, HttpSession httpSession){
        Set<Product> products = (Set<Product>) httpSession.getAttribute("products");
        model.addAttribute("products", products );
        return "cart";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(value = "id") Long id, Model model, HttpSession httpSession){
        Set<Product> products = (Set<Product>) httpSession.getAttribute("products");

        products.remove(product);
        model.addAttribute("products", products);
        return "cart";
    }

    @PostMapping
    public String setOrderOfGoods(Model model){

        return "orderIsAccepted";
    }

    @PostMapping("/add")
    public String addProductToSessionAndGoToCart(Model model, HttpSession httpSession){
        Cart cart = (Cart) httpSession.getAttribute("cart");
        cartService.addItemToCart(cart);

        return "orderIsAccepted";
    }

}
