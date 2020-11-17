package com.github.egorovag.onlineStore.service.impl;

import com.github.egorovag.onlineStore.dao.ProductDao;
import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.model.enums.ProductName;
import com.github.egorovag.onlineStore.service.ProductService;

import java.util.List;

public class DefaultProductService implements ProductService {
    private ProductDao productDao;

    public DefaultProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getProductByProductNameService(ProductName productName) {
        return productDao.getProductByProductNameDao(productName);
    }

    @Override
    public Product getProductByIDService(Long id) {
        return productDao.getProductByIdDao(id);
    }
}
