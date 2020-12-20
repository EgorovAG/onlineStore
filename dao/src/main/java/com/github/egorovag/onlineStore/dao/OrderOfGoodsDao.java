package com.github.egorovag.onlineStore.dao;

import com.github.egorovag.onlineStore.model.OrderOfGoods;

import java.util.List;

public interface OrderOfGoodsDao {
    List<OrderOfGoods> getListOrderOfGoodsDao();

    boolean deleteOrderOfGoodsByIdDao(Long id);

    OrderOfGoods saveOrderOfGoodsDao(OrderOfGoods orderOfGoods);

    OrderOfGoods updateOrderOfGoodsDao(OrderOfGoods orderOfGoods);

    OrderOfGoods getOrderOfGoodsByIdDao(Long id);

    boolean updateOrderCompletedForOrderOfGoodsByIdDao(Long id);

    List<OrderOfGoods> getOrderOfGoodsByAuthUserIdDao(Long id);
}
