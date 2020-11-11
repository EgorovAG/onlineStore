package com.github.egorovag.onlineStore.dao;

import com.github.egorovag.onlineStore.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProductByNameDao(String name);
}
