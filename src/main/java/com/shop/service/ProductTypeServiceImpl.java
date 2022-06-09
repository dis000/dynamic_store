package com.shop.service;

import com.shop.dto.CategoryDto;
import com.shop.dto.ProductShortDto;
import com.shop.exception.CategoryNotFoundException;
import com.shop.exception.ProductNotFoundException;
import com.shop.mapper.ProductMapper;
import com.shop.mapper.ProductTypeMapper;
import com.shop.repository.ProductRepository;
import com.shop.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {


    private final ProductTypeRepository productTypeRepository;
    private final ProductTypeMapper productTypeMapper;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Autowired
    public ProductTypeServiceImpl(
            ProductTypeRepository productTypeRepository,
            ProductTypeMapper productTypeMapper,
            ProductRepository productRepository,
            ProductMapper productMapper
    ) {
        this.productTypeRepository = productTypeRepository;
        this.productTypeMapper = productTypeMapper;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<CategoryDto> categoryDtos = productTypeRepository.findAll().stream()
                .map(productTypeMapper::toDto).collect(toList());

        if (categoryDtos.isEmpty())
            throw new ProductNotFoundException("Продукт не найден");

        return categoryDtos;
    }

    @Override
    public List<ProductShortDto> getShortByCategory(String category, Pageable page) {
        List<ProductShortDto> productShortDtos = productRepository.findProductsByCategory(category, page).stream()
                .map(productMapper::toShortDto)
                .collect(toList());

        if (productShortDtos.isEmpty())
            throw new CategoryNotFoundException("категория пуста или не существует");

        return productShortDtos;

    }


}
