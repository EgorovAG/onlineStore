package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.OrderOfGoods;
import com.github.egorovag.onlineStore.service.OrderOfGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final OrderOfGoodsService orderOfGoodsService;

    public OrderController(OrderOfGoodsService orderOfGoodsService) {
        this.orderOfGoodsService = orderOfGoodsService;
    }

//    @GetMapping()
//    public String getOrderOfGoods(Model model, HttpSession httpSession) {
//        List<OrderOfGoods> orderOfGoods = orderOfGoodsService.getOrderOfGoodsService();
//        return "order";
//    }

    @GetMapping("orderListForSeller")
    public String getOrderOfGoodsForSeller(Model model) {
        List<OrderOfGoods> orderOfGoods = orderOfGoodsService.getOrderOfGoodsService();
        if (orderOfGoods == null || orderOfGoods.isEmpty()) {
            model.addAttribute("orderOfGoods", null);
        } else {
            model.addAttribute("orderOfGoods", orderOfGoods);
        }
        return "orderList";
    }

    @PostMapping("delete")
    public String getOrderOfGoodsForSeller(@RequestParam(value = "id") Long id, Model model) {
        orderOfGoodsService.deleteOrderOfGoodsService(id);
        List<OrderOfGoods> orderOfGoods = orderOfGoodsService.getOrderOfGoodsService();
        if (orderOfGoods == null || orderOfGoods.isEmpty()) {
            model.addAttribute("orderOfGoods", null);
        } else {
            model.addAttribute("orderOfGoods", orderOfGoods);
        }
        return "orderList";
    }

    @PostMapping("orderCompleted")
    public String getOrder(@RequestParam(value = "id") Long id, Model model) {
        orderOfGoodsService.updateOrderCompletedForOrderOfGoodsByIdService(id);
        List<OrderOfGoods> orderOfGoods = orderOfGoodsService.getOrderOfGoodsService();
        if (orderOfGoods == null || orderOfGoods.isEmpty()) {
            model.addAttribute("orderOfGoods", null);
        } else {
            model.addAttribute("orderOfGoods", orderOfGoods);
        }
        return "orderList";
    }

    @PostMapping("orderListForClient")
    public String getOrderListForClient(Model model) {
        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        orderOfGoodsService.getOrderOfGoodsByAuthUserIdService(authUser.getId());
        List<OrderOfGoods> orderOfGoods = orderOfGoodsService.getOrderOfGoodsService();
        if (orderOfGoods == null || orderOfGoods.isEmpty()) {
            model.addAttribute("orderOfGoods", null);
        } else {
            model.addAttribute("orderOfGoods", orderOfGoods);
        }
        return "orderList";
    }
}
