package com.shop.repository;

import com.shop.entity.ValueProductFeature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValueProductFeatureRepository extends JpaRepository<ValueProductFeature, Long> {

    //TODO это
    @Query("select p from ValueProductFeature p where p.productFeature.name = 'memory'")
    List<ValueProductFeature> findAllByProductFeature1(@Param("name") String name);


}
