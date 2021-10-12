package com.shop.repository;

import com.shop.entity.ValueProductFeature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueProductFeatureRepository extends JpaRepository<ValueProductFeature, Long> {
}
