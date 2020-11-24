package com.github.egorovag.onlineStore.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/order")
public class CartController {
    private static final Logger log = LoggerFactory.getLogger(CartController.class);

    @PostMapping
    public String setOrderOfGoods(Model model){

        return "orderIsAccepted";
    }

}
