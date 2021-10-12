package com.shop.repository;

import com.shop.entity.Product;
import com.shop.entity.ValueProductFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
      List<Product> findByValueProductCharacteristicIn(Iterable<ValueProductFeature> valueCharacteristics);

  //    Product findByProductTypeOrderByName(Product productType);



}
