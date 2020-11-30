package com.github.egorovag.onlineStore.dao.impl;

import com.github.egorovag.onlineStore.dao.ProductDao;
import com.github.egorovag.onlineStore.dao.converter.ProductConverter;
import com.github.egorovag.onlineStore.dao.entity.ProductEntity;
import com.github.egorovag.onlineStore.dao.repository.ProductJpaRepository;
import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.model.enums.ProductName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DefaultProductDao implements ProductDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultProductDao.class);

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public List<Product> getProductByProductNameDao(ProductName productName) {
        try {
            List<ProductEntity> productsEntities = productJpaRepository.findByProductName(productName);
            log.info("Product with name: {} read", productName);
            return productsEntities.stream()
                    .map(ProductConverter::fromEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Fail to read product with name: {}", productName, e);
            return null;
        }
    }

    @Override
    public Product getProductByIdDao(Long id) {
        try {
            ProductEntity productEntity = productJpaRepository.findById(id).orElse(null);
            log.info("Product with id: {} read", id);
            return ProductConverter.fromEntity(productEntity);
        } catch (Exception e) {
            log.error("Fail to read product with id: {}", id, e);
            return null;
        }
    }

    @Override
    public void saveProductDao(Product product) {
        try {
            ProductEntity productEntity = ProductConverter.toEntity(product);
            ProductJpaRepository productJpaRepository = this.productJpaRepository;
            productJpaRepository.save(productEntity);
            log.info("Product with name: {} saved", product.getName());
        } catch (Exception e) {
            log.error("Fail to save product with name: {}", product.getName(), e);
        }
    }

    @Override
    public boolean deleteProductByIdDao(Long id) {
        try {
            productJpaRepository.deleteById(id);
            log.info("Product with id: {} deleted", id);
            return true;
        } catch (Exception e) {
            log.error("Fail to delete product with id: {}", id, e);
            return false;
        }
    }
}
