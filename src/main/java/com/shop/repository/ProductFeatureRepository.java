package com.shop.repository;

import com.shop.entity.ProductFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductFeatureRepository extends JpaRepository<ProductFeature, Long> {

}
