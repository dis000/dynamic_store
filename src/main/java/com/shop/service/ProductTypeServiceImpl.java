package com.shop.service;

import com.shop.dto.CategoryDto;
import com.shop.dto.ProductShortDto;
import com.shop.exception.CategoryNotFoundException;
import com.shop.exception.ProductNotFoundException;
import com.shop.mapper.ProductShortMapper;
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
    private final ProductShortMapper productShortMapper;


    @Autowired
    public ProductTypeServiceImpl(
            ProductTypeRepository productTypeRepository,
            ProductTypeMapper productTypeMapper,
            ProductRepository productRepository,
            ProductShortMapper productShortMapper
    ) {
        this.productTypeRepository = productTypeRepository;
        this.productTypeMapper = productTypeMapper;
        this.productRepository = productRepository;
        this.productShortMapper = productShortMapper;
    }

    @Override
    public List<CategoryDto> getCategories(Pageable page) {
        List<CategoryDto> categoryDtos = productTypeRepository.findAll(page).stream()
                .map(productTypeMapper::toDto).collect(toList());

        if (categoryDtos.isEmpty())
            throw new ProductNotFoundException("Продукт не найден");

        return categoryDtos;

    }

    @Override
    public List<ProductShortDto> getShortByCategory(String category, Pageable page) {
        List<ProductShortDto> productShortDtos = productRepository.findProductsByCategory(category, page).stream()
                .map(productShortMapper::toDto)
                .collect(toList());

        if (productShortDtos.isEmpty())
            throw new CategoryNotFoundException("категория пуста или не существует");

        return productShortDtos;

    }


}
