package com.shop.service;

import com.shop.entity.ProductType;
import com.shop.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService implements IProductTypeService{

    @Autowired
    ProductTypeRepository productTypeRepository;


    @Override
    public ProductType findByCategory(String category) {
        return productTypeRepository.findAllByNameCategory(category);
    }
}
