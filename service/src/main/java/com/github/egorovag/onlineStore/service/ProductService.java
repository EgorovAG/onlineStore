package com.github.egorovag.onlineStore.service;

import com.github.egorovag.onlineStore.model.Product;

import java.util.List;


public interface ProductService {
    List<Product> getProductByNameService();
}
