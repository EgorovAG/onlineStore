package com.github.egorovag.onlineStore.model;

import com.github.egorovag.onlineStore.model.enums.OrderStatus;

import java.time.LocalDate;

public class OrderOfGoods {
    private long id;
    private long user_id;
    private long product_id;
    private LocalDate dateOrder;
    private int quantityOrder;
    private OrderStatus orderStatus;
    private String deliveryAddress;
    private LocalDate deliveryDate;

    public OrderOfGoods() {
    }

    public OrderOfGoods(long id, long user_id, long product_id, LocalDate dateOrder, int quantityOrder, OrderStatus orderStatus, String deliveryAddress, LocalDate deliveryDate) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
