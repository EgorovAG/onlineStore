package com.github.egorovag.onlineStore.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class GoToPage {

    @GetMapping("/toHomePageJspx")
    public String toHomePage() {
        return "index";
    }

    @GetMapping("/toShippingAndPaymentPageJspx")
    public String toShippingAndPaymentPage() {
        return "shippingAndPayment";
    }

    @GetMapping("/toWarrantyPageJspx")
    public String toWarrantyPage() {
        return "warranty";
    }

    @GetMapping("/toAboutUsPageJspx")
    public String toAboutUsPage() {
        return "aboutUS";
    }

    @GetMapping("/toEntryPageJspx")
    public String toEntryPage() {
        return "entry";
    }

    @GetMapping("/toOrderListJspx")
    public String toOrderList() {
        return "orderList";
    }
}