package com.github.egorovag.onlineStore.service.impl;

import com.github.egorovag.onlineStore.dao.OrderOfGoodsDao;
import com.github.egorovag.onlineStore.model.OrderOfGoods;
import com.github.egorovag.onlineStore.service.OrderOfGoodsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DefaultOrderOfGoodsService implements OrderOfGoodsService {
    private OrderOfGoodsDao orderOfGoodsDao;

    public DefaultOrderOfGoodsService(OrderOfGoodsDao orderOfGoodsDao) {
        this.orderOfGoodsDao = orderOfGoodsDao;
    }

    @Override
    @Transactional
    public List<OrderOfGoods> getOrderOfGoodsService() {
        return orderOfGoodsDao.getListOrderOfGoodsDao();
    }

    @Override
    @Transactional
    public void deleteOrderOfGoodsService(Long id) {
        orderOfGoodsDao.deleteOrderOfGoodsByIdDao(id);
    }

    @Override
    @Transactional
    public void updateOrderCompletedForOrderOfGoodsByIdService(Long id) {
        orderOfGoodsDao.updateOrderCompletedForOrderOfGoodsByIdDao(id);
    }

    @Override
    public List<OrderOfGoods> getOrderOfGoodsByAuthUserIdService(Long id) {
        return orderOfGoodsDao.getOrderOfGoodsByAuthUserIdDao(id);
    }
}
