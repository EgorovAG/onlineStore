package com.github.egorovag.onlineStore.service.impl;

import com.github.egorovag.onlineStore.dao.ProductDao;
import com.github.egorovag.onlineStore.service.ProductService;

public class DefaultProductService implements ProductService {
    ProductDao productDao;

    public DefaultProductService(ProductDao productDao) {
        this.productDao = productDao;
    }
}
