package com.github.egorovag.onlineStore.dao.converter;

import com.github.egorovag.onlineStore.dao.entity.OrderOfGoodsEntity;
import com.github.egorovag.onlineStore.model.OrderOfGoods;

public class OrderOfGoodsConverter {
    public static OrderOfGoods fromEntity(OrderOfGoodsEntity orderOfGoodsEntity) {
        if (orderOfGoodsEntity == null) {
            return null;
        }
        return new OrderOfGoods(
                orderOfGoodsEntity.getId(),
                orderOfGoodsEntity.getUser_id(),
                orderOfGoodsEntity.getProduct_id(),
                orderOfGoodsEntity.getDateOrder(),
                orderOfGoodsEntity.getPriceOrder(),
                orderOfGoodsEntity.getQuantityOrder(),
                orderOfGoodsEntity.getOrderStatus(),
                orderOfGoodsEntity.getDeliveryAddress(),
                orderOfGoodsEntity.getDeliveryDate());
    }

    public static OrderOfGoodsEntity toEntity(OrderOfGoods orderOfGoods) {
        if (orderOfGoods == null) {
            return null;
        }
        final OrderOfGoodsEntity orderOfGoodsEntity = new OrderOfGoodsEntity();
        orderOfGoodsEntity.setId(orderOfGoods.getId());
        orderOfGoodsEntity.setUser_id(orderOfGoods.getUser_id());
        orderOfGoodsEntity.setProduct_id(orderOfGoods.getProduct_id());
        orderOfGoodsEntity.setDateOrder(orderOfGoods.getDateOrder());
        orderOfGoodsEntity.setPriceOrder(orderOfGoods.getPriceOrder());
        orderOfGoodsEntity.setQuantityOrder(orderOfGoods.getQuantityOrder());
        orderOfGoodsEntity.setOrderStatus(orderOfGoods.getOrderStatus());
        orderOfGoodsEntity.setDeliveryAddress(orderOfGoods.getDeliveryAddress());
        orderOfGoodsEntity.setDeliveryDate(orderOfGoods.getDeliveryDate());
        return orderOfGoodsEntity;
    }
}
