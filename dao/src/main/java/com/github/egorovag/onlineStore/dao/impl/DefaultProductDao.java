package com.github.egorovag.onlineStore.dao.impl;

import com.github.egorovag.onlineStore.dao.ProductDao;
import com.github.egorovag.onlineStore.dao.converter.ProductConverter;
import com.github.egorovag.onlineStore.dao.entity.ProductEntity;
import com.github.egorovag.onlineStore.dao.repository.ProductJpaRepository;
import com.github.egorovag.onlineStore.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultProductDao implements ProductDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultProductDao.class);

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public List<Product> getProductByNameDao(String name) {
        try {
            List<ProductEntity> productsEntities = productJpaRepository.findByName(name);
            log.info("Product with name: {} read", name);
            return productsEntities.stream()
                    .map(ProductConverter::fromEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.info("Fail to read product with name: {}", name, e);
            return null;
//            orderClientEntities.stream()
//                    .map(OrderClientConverter::fromEntity)
//                    .collect(Collectors.toList());
        }
    }
}
