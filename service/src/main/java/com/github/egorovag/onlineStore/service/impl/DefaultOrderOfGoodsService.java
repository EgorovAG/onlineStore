package com.github.egorovag.onlineStore.service.impl;

import com.github.egorovag.onlineStore.dao.OrderOfGoodsDao;
import com.github.egorovag.onlineStore.model.OrderOfGoods;
import com.github.egorovag.onlineStore.service.OrderOfGoodsService;

import java.util.List;

public class DefaultOrderOfGoodsService implements OrderOfGoodsService {
    private OrderOfGoodsDao orderOfGoodsDao;

    public DefaultOrderOfGoodsService(OrderOfGoodsDao orderOfGoodsDao) {
        this.orderOfGoodsDao = orderOfGoodsDao;
    }

    @Override
    public List<OrderOfGoods> getOrderOfGoodsService() {
        return orderOfGoodsDao.getOrderOfGoodsDao();
    }
}
