package com.github.egorovag.onlineStore.dao.converter;

import com.github.egorovag.onlineStore.dao.entity.ProductEntity;
import com.github.egorovag.onlineStore.model.Product;

public class ProductConverter {
    public static Product fromEntity(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        return new Product(
                productEntity.getId(),
                productEntity.getProductName(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getQuantity());
    }

    public static ProductEntity toEntity(Product product) {
        if (product == null) {
            return null;
        }
        final ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setProductName(product.getProductName());
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantity(product.getQuantity());
        return productEntity;
    }
}