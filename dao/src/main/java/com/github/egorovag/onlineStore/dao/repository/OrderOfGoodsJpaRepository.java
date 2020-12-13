package com.github.egorovag.onlineStore.dao.repository;

import com.github.egorovag.onlineStore.dao.entity.OrderOfGoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderOfGoodsJpaRepository extends JpaRepository<OrderOfGoodsEntity, Long> {

}
