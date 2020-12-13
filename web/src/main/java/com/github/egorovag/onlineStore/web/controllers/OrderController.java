package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.OrderOfGoods;
import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.service.OrderOfGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private OrderOfGoodsService orderOfGoodsService;

    @GetMapping()
    public String getOrderOfGoods(Model model, HttpSession httpSession) {
        List<OrderOfGoods> orderOfGoods = orderOfGoodsService.getOrderOfGoodsService();

        return "order";
    }

}
