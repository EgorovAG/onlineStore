package com.github.egorovag.onlineStore.service;

import com.github.egorovag.onlineStore.model.OrderOfGoods;

import java.util.List;

public interface OrderOfGoodsService {
    List<OrderOfGoods> getOrderOfGoodsService();

    void deleteOrderOfGoodsService(Long id);

    void updateOrderCompletedForOrderOfGoodsByIdService(Long id);

    List<OrderOfGoods> getOrderOfGoodsByAuthUserIdService(Long id);
}
