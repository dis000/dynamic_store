package com.shop.repository;

import com.shop.entity.ValueProductCharacteristic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueProductCharacteristicRepository extends JpaRepository<ValueProductCharacteristic, Long> {
}
