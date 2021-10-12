package com.shop.repository;

import com.shop.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    //TODO или это
    ProductType findAllByNameCategory(String category);
}
