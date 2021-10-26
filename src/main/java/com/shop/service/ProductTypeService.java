package com.shop.service;

import com.shop.entity.ProductType;
import com.shop.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService implements IProductTypeService{


    ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public ProductType getByCategory(String category) {
        return productTypeRepository.findAllByNameCategory(category);
    }

}
