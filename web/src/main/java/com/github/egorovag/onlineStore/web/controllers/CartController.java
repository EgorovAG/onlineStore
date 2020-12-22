package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.Cart;
import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;


@Controller
@RequestMapping("/cart")
public class CartController {
    private static final Logger log = LoggerFactory.getLogger(CartController.class);
    private CartService cartService;
    private Product product;

    @GetMapping()
    public String goToCart(Model model, HttpSession httpSession) {
        List<Product> productsInTheCart = (List<Product>) httpSession.getAttribute("productsInTheCart");
        model.addAttribute("productsInTheCart", productsInTheCart);
        return "cart";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(value = "id") Long id, Model model, HttpSession httpSession) {
        List<Product> listProductsInTheCart = (List<Product>) httpSession.getAttribute("productsInTheCart");
        Iterator<Product> iteratorProduct = listProductsInTheCart.iterator();
      while(iteratorProduct.hasNext()){
          Product delProduct = iteratorProduct.next();
          if ( delProduct.getId()==id) {
              iteratorProduct.remove();
          }
      }
      httpSession.setAttribute("productsInTheCart", listProductsInTheCart);
        return "cart";
    }

    @PostMapping("/addProduct")
    public String addProduct(Product productsInTheCart,
                             @RequestParam(value = "productName") String productName, Model model,
                             HttpSession httpSession) {
        List<Product> listProductsInTheCart = (List<Product>) httpSession.getAttribute("productsInTheCart");
        listProductsInTheCart.add(productsInTheCart);
//        httpSession.removeAttribute("productsInTheCart");
        httpSession.setAttribute("productsInTheCart", listProductsInTheCart);
        model.addAttribute("productName", productName);
        return "redirect:/catalog/product";
    }

    @PostMapping
    public String setOrderOfGoods(Model model) {

        return "orderIsAccepted";
    }

    @PostMapping("/add")
    public String addProductToSessionAndGoToCart(Model model, HttpSession httpSession) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        cartService.addItemToCart(cart);

        return "orderIsAccepted";
    }

    @PostMapping("/ordering")
    public String ordering(Model map) {
        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(authUser==null){
            map.addAttribute("errorLogIn", "error.logInOrder");
            return "login";
        }
        return "orderIsAccepted";
    }

}
