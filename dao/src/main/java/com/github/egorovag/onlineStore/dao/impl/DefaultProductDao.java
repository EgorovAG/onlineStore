package com.github.egorovag.onlineStore.dao.impl;

import com.github.egorovag.onlineStore.dao.ProductDao;
import com.github.egorovag.onlineStore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DefaultProductDao implements ProductDao {
    @Override
    public List<Product> getProductByNameDao(String name) {

        List<Product> products = new ArrayList<>();

        return products;
    }
}
