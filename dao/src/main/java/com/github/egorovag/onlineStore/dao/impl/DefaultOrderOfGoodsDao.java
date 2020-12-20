package com.github.egorovag.onlineStore.dao.impl;

import com.github.egorovag.onlineStore.dao.OrderOfGoodsDao;
import com.github.egorovag.onlineStore.dao.ProductDao;
import com.github.egorovag.onlineStore.dao.UserDao;
import com.github.egorovag.onlineStore.dao.converter.OrderOfGoodsConverter;
import com.github.egorovag.onlineStore.dao.converter.ProductConverter;
import com.github.egorovag.onlineStore.dao.converter.UserConverter;
import com.github.egorovag.onlineStore.dao.entity.OrderOfGoodsEntity;
import com.github.egorovag.onlineStore.dao.entity.ProductEntity;
import com.github.egorovag.onlineStore.dao.entity.UserEntity;
import com.github.egorovag.onlineStore.dao.repository.OrderOfGoodsJpaRepository;
import com.github.egorovag.onlineStore.model.OrderOfGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultOrderOfGoodsDao implements OrderOfGoodsDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultOrderOfGoodsDao.class);
    private final UserDao userDao;
    private final ProductDao productDao;

    @Autowired
    OrderOfGoodsJpaRepository orderOfGoodsJpaRepository;

    public DefaultOrderOfGoodsDao(UserDao userDao, ProductDao productDao) {
        this.userDao = userDao;
        this.productDao = productDao;
    }

    @Override
    public List<OrderOfGoods> getListOrderOfGoodsDao() {
        try {
            List<OrderOfGoodsEntity> orderOfGoodsEntities = orderOfGoodsJpaRepository.findAll();
            log.info("OrderOfGoods read");
            return orderOfGoodsEntities.stream()
                    .map(OrderOfGoodsConverter::fromEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Fail to read OrderOfGoods", e);
            return null;
        }
    }

    @Override
    public boolean deleteOrderOfGoodsByIdDao(Long id) {
        try {
            orderOfGoodsJpaRepository.deleteById(id);
            log.info("OrderOfGoods with : {} id deleted", id);
            return true;
        } catch (Exception e) {
            log.error("Fail to delete OrderOfGoods with : {} id ", id, e);
            return false;
        }
    }

    @Override
    public OrderOfGoods saveOrderOfGoodsDao(OrderOfGoods orderOfGoods) {
        try {
            OrderOfGoodsEntity orderOfGoodsEntity = OrderOfGoodsConverter.toEntity(orderOfGoods);
            UserEntity userEntity = UserConverter.toEntity(userDao.readUserByUserIdDao(orderOfGoods.getUser_id()));
            ProductEntity productEntity = ProductConverter.toEntity(productDao.getProductByIdDao(orderOfGoods.getProduct_id()));
            orderOfGoodsEntity.setUserEntity(userEntity);
            orderOfGoodsEntity.setProductEntity(productEntity);
            OrderOfGoodsEntity saveOrderOfGoodsEntity = orderOfGoodsJpaRepository.save(orderOfGoodsEntity);
            log.info("OrderOfGoods with : {} product_id saved", orderOfGoods.getProduct_id());
            return OrderOfGoodsConverter.fromEntity(saveOrderOfGoodsEntity);
        } catch (Exception e) {
            log.error("Fail to save OrderOfGoods with : {} product_id ", orderOfGoods.getProduct_id(), e);
            return null;
        }
    }

    @Override
    public OrderOfGoods updateOrderOfGoodsDao(OrderOfGoods orderOfGoods) {
        try {
            OrderOfGoodsEntity orderOfGoodsEntity = OrderOfGoodsConverter.toEntity(orderOfGoods);
            UserEntity userEntity = UserConverter.toEntity(userDao.readUserByUserIdDao(orderOfGoods.getUser_id()));
            ProductEntity productEntity = ProductConverter.toEntity(productDao.getProductByIdDao(orderOfGoods.getProduct_id()));
            orderOfGoodsEntity.setUserEntity(userEntity);
            orderOfGoodsEntity.setProductEntity(productEntity);
            OrderOfGoodsEntity saveOrderOfGoodsEntity = orderOfGoodsJpaRepository.save(orderOfGoodsEntity);
            log.info("OrderOfGoods with : {} id updated", orderOfGoods.getId());
            return OrderOfGoodsConverter.fromEntity(saveOrderOfGoodsEntity);
        } catch (Exception e) {
            log.error("Fail to update OrderOfGoods with : {} id ", orderOfGoods.getId(), e);
            return null;
        }
    }

    @Override
    public OrderOfGoods getOrderOfGoodsByIdDao(Long id) {
        try {
            OrderOfGoodsEntity orderOfGoodsEntity = orderOfGoodsJpaRepository.findById(id).orElse(null);
            log.info("OrderOfGoods with : {} id read", id);
            return OrderOfGoodsConverter.fromEntity(orderOfGoodsEntity);
        } catch (Exception e) {
            log.error("Fail to read OrderOfGoods with : {} id ", id, e);
            return null;
        }
    }

    @Override
    public boolean updateOrderCompletedForOrderOfGoodsByIdDao(Long id) {
        try {
            orderOfGoodsJpaRepository.updateOrderCompletedForOrderOfGoodsById(id);
            log.info("OrderOfGoods with : {} id updated", id);
            return true;
        } catch (Exception e) {
            log.error("Fail to update OrderOfGoods with : {} id ", id, e);
            return false;

        }
    }

    @Override
    public List<OrderOfGoods> getOrderOfGoodsByAuthUserIdDao(Long id) {
        try {
            List<OrderOfGoodsEntity> orderOfGoodsEntities = orderOfGoodsJpaRepository.getOrderOfGoodsByAuthUser_IdDao(id);
            log.info("OrderOfGoods read");
            return orderOfGoodsEntities.stream()
                    .map(OrderOfGoodsConverter::fromEntity)
                    .collect(Collectors.toList());
        } catch (
                Exception e) {
            log.error("Fail to read OrderOfGoods", e);
            return null;
        }
    }
}

