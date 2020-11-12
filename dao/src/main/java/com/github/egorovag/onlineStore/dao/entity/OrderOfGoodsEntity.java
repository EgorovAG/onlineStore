package com.github.egorovag.onlineStore.dao.entity;


import com.github.egorovag.onlineStore.model.enums.OrderStatus;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "orderOfGoods")
public class OrderOfGoodsEntity {
    private long id;
    private long user_id;
    private long product_id;
    private LocalDate dateOrder;
    private int quantityOrder;
    private OrderStatus orderStatus;
    private String deliveryAddress;
    private LocalDate deliveryDate;

    private UserEntity userEntity;
    private ProductEntity productEntity;

    public OrderOfGoodsEntity() {
    }

    public OrderOfGoodsEntity(long id, long user_id, long product_id, LocalDate dateOrder,
                              int quantityOrder, OrderStatus orderStatus, String deliveryAddress,
                              LocalDate deliveryDate, UserEntity userEntity, ProductEntity productEntity) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.dateOrder = dateOrder;
        this.quantityOrder = quantityOrder;
        this.orderStatus = orderStatus;
        this.deliveryAddress = deliveryAddress;
        this.deliveryDate = deliveryDate;
        this.userEntity = userEntity;
        this.productEntity = productEntity;
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

    @Column(name = "user_id", insertable = false, updatable = false)
    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    @Column(name = "user_id", insertable = false, updatable = false)
    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    @Column
    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    @Column
    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "orderStatus")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Column
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Column
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
