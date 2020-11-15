package com.github.egorovag.onlineStore.dao.entity;

import com.github.egorovag.onlineStore.model.enums.ProductName;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "product")
public class ProductEntity {
    private long id;
    private ProductName productName;
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

    @Enumerated(EnumType.STRING)
    @Column
    public ProductName getProductName() {
        return productName;
    }

    public void setProductName(ProductName productName) {
        this.productName = productName;
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

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<OrderOfGoodsEntity> getOrderOfGoodsEntities() {
        return orderOfGoodsEntities;
    }

    public void setOrderOfGoodsEntities(List<OrderOfGoodsEntity> orderOfGoodsEntities) {
        this.orderOfGoodsEntities = orderOfGoodsEntities;
    }
}
