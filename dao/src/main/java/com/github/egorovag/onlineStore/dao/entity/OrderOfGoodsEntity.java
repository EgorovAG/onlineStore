package com.github.egorovag.onlineStore.dao.entity;


import java.time.LocalDate;

public class OrderOfGoodsEntity {
    private long id;
    private long user_id;
    private long product_id;
    private LocalDate dateOrder;
    private int quantityOrder;
    private OrderStatus orderStatus;
    private String deliveryAddress;
    private String deliveryDate;
}
