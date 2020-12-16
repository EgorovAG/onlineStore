package com.github.egorovag.onlineStore.dao.repository;

import com.github.egorovag.onlineStore.dao.entity.ProductEntity;
import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.model.enums.ProductName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByProductName(ProductName productName);

    @Modifying
    @Transactional
    @Query(value = "update ProductEntity  set productName = :productName, name = :name, description = :description," +
            "quantity = :quantity, price = :price  where id = :id ")
    void updateProductByProduct(@Param("id") Long id, @Param("productName") ProductName productName,
                                @Param("name") String name,
                                @Param("description") String description, @Param("quantity") int quantity,
                                @Param("price") int price);

}
