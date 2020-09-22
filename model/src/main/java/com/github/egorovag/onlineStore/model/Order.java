package com.github.egorovag.onlineStore.model;

import com.github.egorovag.onlineStore.model.enums.OrderStatus;

import java.time.LocalDate;

public class Order {
    private long id;
    private long user_id;
    private long product_id;
    private LocalDate dateOrder;
    private int quantityOrder;
    private OrderStatus orderStatus;
    private String deliveryAddress;
    private String deliveryDate;
}
