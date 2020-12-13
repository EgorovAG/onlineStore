package com.github.egorovag.onlineStore.dao;


import com.github.egorovag.onlineStore.dao.ProductDao;
import com.github.egorovag.onlineStore.dao.config.DaoConfig;
import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.model.enums.ProductName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
class DefaultProductDaoTest {
    @Autowired
    ProductDao productDao;
    Product productNew;

    @BeforeEach
    void createProduct() {
        Product product = new Product(ProductName.Faucets, "Gloria", "this is super faucet", 30, 5);
        productNew = productDao.saveProductDao(product);

    }

    @Test
    void testGetProductByNameDao() {
        List<Product> products = productDao.getProductByProductNameDao(ProductName.Faucets);
        Assertions.assertEquals(ProductName.Faucets, products.get(0).getProductName());
    }

    @Test
    void testGetProductByIdDao() {
        Product product = productDao.getProductByIdDao(productNew.getId());
        Assertions.assertEquals(ProductName.Faucets, product.getProductName());
    }

    @Test
    void testSaveProductDao() {
        Assertions.assertEquals(ProductName.Faucets, productNew.getProductName());
    }

    @Test
    void testDeleteProductDao() {
        boolean res = productDao.deleteProductByIdDao(productNew.getId());
        Assertions.assertTrue(res);
    }

}