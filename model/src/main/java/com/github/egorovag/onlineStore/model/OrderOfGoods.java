package com.github.egorovag.onlineStore.model;

import com.github.egorovag.onlineStore.model.enums.OrderStatus;

import java.time.LocalDate;

public class OrderOfGoods {
    private Long id;
    private Long user_id;
    private Long product_id;
    private LocalDate dateOrder;
    private int priceOrder;
    private int quantityOrder;
    private OrderStatus orderStatus;
    private String deliveryAddress;
    private LocalDate deliveryDate;

    public OrderOfGoods() {
    }

    public OrderOfGoods(Long id, Long user_id, Long product_id, LocalDate dateOrder, int priceOrder, int quantityOrder,
                        OrderStatus orderStatus, String deliveryAddress, LocalDate deliveryDate) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.dateOrder = dateOrder;
        this.priceOrder = priceOrder;
        this.quantityOrder = quantityOrder;
        this.orderStatus = orderStatus;
        this.deliveryAddress = deliveryAddress;
        this.deliveryDate = deliveryDate;
    }

    public OrderOfGoods(Long user_id, Long product_id, LocalDate dateOrder, int priceOrder, int quantityOrder,
                        OrderStatus orderStatus, String deliveryAddress, LocalDate deliveryDate) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.dateOrder = dateOrder;
        this.priceOrder = priceOrder;
        this.quantityOrder = quantityOrder;
        this.orderStatus = orderStatus;
        this.deliveryAddress = deliveryAddress;
        this.deliveryDate = deliveryDate;
    }

    public OrderOfGoods(Long user_id) {
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(int priceOrder) {
        this.priceOrder = priceOrder;
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
