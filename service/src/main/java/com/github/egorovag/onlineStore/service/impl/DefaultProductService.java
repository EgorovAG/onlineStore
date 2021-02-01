package com.github.egorovag.onlineStore.service.impl;

import com.github.egorovag.onlineStore.dao.ProductDao;
import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.model.enums.ProductName;
import com.github.egorovag.onlineStore.service.ProductService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
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
    public Product getProductByIdService(Long id) {
        return productDao.getProductByIdDao(id);
    }

    @Override
    public boolean deleteProductByIdService(Long id) {
        return productDao.deleteProductByIdDao(id);
    }

    @Override
    public Product saveProductService(Product product) {
        return productDao.saveProductDao(product);
    }

    @Override
    public void updateProductService(Product product) {
        productDao.updateProductDao(product);

    }
}
