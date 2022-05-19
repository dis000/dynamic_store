package com.shop.repository;

import com.shop.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  //  List<Product> findByValueProductCharacteristicIn(Iterable<ValueProductFeature> valueCharacteristics);

  //    Product findByProductTypeOrderByName(Product productType);
  @Query(value = "select distinct p from Product p where lower(p.name) like lower(CONCAT('%', :name, '%'))")
  Set<Product> findByName(@Param("name") String name);


  @Query(value = "select distinct p from Product p inner join p.productType where lower(p.productType.nameCategory) = lower(:category) order by p.price")
  List<Product> findProductsByCategory(@Param("category") String category, Pageable page);

}
