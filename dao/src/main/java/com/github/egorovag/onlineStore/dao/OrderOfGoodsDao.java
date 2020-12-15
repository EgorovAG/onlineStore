package com.github.egorovag.onlineStore.dao;

import com.github.egorovag.onlineStore.model.OrderOfGoods;

import java.util.List;

public interface OrderOfGoodsDao {
    List<OrderOfGoods> getListOrderOfGoodsDao();

    boolean deleteOrderOfGoodsDao(Long id);

    OrderOfGoods saveOrderOfGoodsDao(OrderOfGoods orderOfGoods);

    OrderOfGoods updateOrderOfGoodsDao(OrderOfGoods orderOfGoods);

    OrderOfGoods getOrderOfGoodsDao(Long id);

    boolean updateOrderCompletedForOrderOfGoodsByIdDao(Long id);
}
