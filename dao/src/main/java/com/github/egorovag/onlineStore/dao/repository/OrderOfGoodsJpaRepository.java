package com.github.egorovag.onlineStore.dao.repository;

import com.github.egorovag.onlineStore.dao.entity.OrderOfGoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface OrderOfGoodsJpaRepository extends JpaRepository<OrderOfGoodsEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = "update OrderOfGoodsEntity  set orderStatus = 'OrderCompleted' where id = :id ")
    void updateOrderCompletedForOrderOfGoodsById(@Param("id") Long id );

    @Query(value = "select og from OrderOfGoodsEntity og join AuthUserEntity au on au.user_id=og.user_id " +
            "where au.id = :id")
    List<OrderOfGoodsEntity> getOrderOfGoodsByAuthUser_IdDao(@Param("id") Long id);





}
