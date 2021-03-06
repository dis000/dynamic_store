package com.shop.repository;

import com.shop.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query(value = "select distinct p from Product p where lower(p.name) like lower(CONCAT('%', :name, '%')) order by p.price")
  List<Product> findByName(@Param("name") String name);


  @Query(value = "select distinct p from Product p " +
          "inner join p.productType pt where lower(pt.nameCategory) = lower(:category) order by p.price")
  List<Product> findProductsByCategory(@Param("category") String category, Pageable page);

  @Query(value = "select distinct p from Product p " +
          " where p.priceWithoutDiscount is not NULL")
  List<Product> findProductsByDiscount(Pageable page);


  @Query(value = "select p from Product p " +
          "left join fetch p.valueProductFeature vpf " +
          "left join fetch vpf.productFeature " +
          "left join fetch p.productType " +
          "left join fetch p.productPictures " +
          "left join fetch p.productComment " +
          "where  p.id = :id")
  Optional<Product> findProductById(@Param("id") Long id);

}
