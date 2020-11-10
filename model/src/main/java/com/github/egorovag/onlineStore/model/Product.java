package com.github.egorovag.onlineStore.model;

public class Product {
    private long id;
    private String name;
    private String description;
    private int price;
    private int quantity;

    public Product(int i, String s, String asd, int i1) {
    }

    public Product(long id, String name, String description, int price, int quantity) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
