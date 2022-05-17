package com.shop.service;

import com.shop.dto.ProductDto;
import com.shop.entity.ProductType;
import com.shop.mapper.ProductMapper;
import com.shop.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductTypeService implements IProductTypeService{


    ProductTypeRepository productTypeRepository;
    ProductMapper productMapper;

    @Autowired
    public ProductTypeService(ProductTypeRepository productTypeRepository,
                              ProductMapper productMapper) {
        this.productTypeRepository = productTypeRepository;
        this.productMapper = productMapper;
    }

}
