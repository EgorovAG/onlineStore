package com.github.egorovag.onlineStore.dao.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "user")
public class UserEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private AuthUserEntity authUserEntity;
    private List<OrderOfGoodsEntity> orderOfGoodsEntityList;

    public UserEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToOne(mappedBy = "userEntity", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    public AuthUserEntity getAuthUserEntity() {
        return authUserEntity;
    }

    public void setAuthUserEntity(AuthUserEntity authUserEntity) {
        this.authUserEntity = authUserEntity;
    }

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<OrderOfGoodsEntity> getOrderOfGoodsEntityList() {
        return orderOfGoodsEntityList;
    }

    public void setOrderOfGoodsEntityList(List<OrderOfGoodsEntity> orderOfGoodsEntityList) {
        this.orderOfGoodsEntityList = orderOfGoodsEntityList;
    }
}

