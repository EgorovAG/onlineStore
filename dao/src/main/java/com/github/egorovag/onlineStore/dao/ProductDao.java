package com.github.egorovag.onlineStore.dao;

import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.model.enums.ProductName;

import java.util.List;

public interface ProductDao {
    List<Product> getProductByProductNameDao(ProductName productName);

    Product getProductByIdDao(Long id);

    Product saveProductDao(Product product);

    boolean deleteProductByIdDao(Long id);

    boolean updateProductDao(Product product);
}
