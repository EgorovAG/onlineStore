package com.github.egorovag.onlineStore.dao.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "product")
public class ProductEntity {
    private long id;
    private String name;
    private String description;
    private int price;
    private int quantity;

    private List<OrderOfGoodsEntity> orderOfGoodsEntities;

    public ProductEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @OneToMany(mappedBy = "ProductEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<OrderOfGoodsEntity> getOrderOfGoodsEntities() {
        return orderOfGoodsEntities;
    }

    public void setOrderOfGoodsEntities(List<OrderOfGoodsEntity> orderOfGoodsEntities) {
        this.orderOfGoodsEntities = orderOfGoodsEntities;
    }
}
