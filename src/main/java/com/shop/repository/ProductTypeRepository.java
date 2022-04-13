package com.shop.repository;

import com.shop.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    //TODO или это
    @Query(value = "select pt from ProductType pt inner join pt.products where pt.nameCategory = :category")
    ProductType findProductsByCategory(@Param("category") String category);

}
