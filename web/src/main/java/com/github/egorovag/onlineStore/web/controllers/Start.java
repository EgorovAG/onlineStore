package com.github.egorovag.onlineStore.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Start {

    @GetMapping("/")
    public String doGet() {
        return "index";
    }
}
