package com.github.egorovag.onlineStore.service;

import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.model.enums.ProductName;

import java.util.List;


public interface ProductService {
    List<Product> getProductByProductNameService(ProductName productName);

    Product getProductByIDService(Long id);
}
