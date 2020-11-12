package com.github.egorovag.onlineStore.dao.repository;

import com.github.egorovag.onlineStore.dao.entity.ProductEntity;
import com.github.egorovag.onlineStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByName(String name);

}
