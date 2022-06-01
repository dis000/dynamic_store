package com.shop.service;

import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;
import com.shop.dto.ValueProductFeatureDto;
import com.shop.entity.Product;
import com.shop.exception.ProductNotFoundException;
import com.shop.mapper.ProductMapper;
import com.shop.mapper.ValueProductFeatureMapper;
import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ValueProductFeatureMapper valueProductFeatureMapper;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper,
                              ValueProductFeatureMapper valueProductFeatureMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.valueProductFeatureMapper = valueProductFeatureMapper;
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(ProductNotFoundException::new);


        List<ValueProductFeatureDto> productFeatures = product.getValueProductFeature().stream()
                .map(valueProductFeatureMapper::toDto).collect(toList());


        return productMapper.toDto(product, productFeatures);
    }

    @Override
    public List<ProductShortDto> getProductsByName(String name) {

        Set<Product> products = productRepository.findByName(name);


        return products.stream().map(productMapper::toShortDto).collect(toList());
    }

    @Override
    public List<ProductShortDto> getProductByDiscount(Pageable page) {
        List<Product> products = productRepository.findProductsByDiscount(page);

        if (products.isEmpty())
            throw new ProductNotFoundException("Продукт со скидкой не найден");

        return products.stream().map(productMapper::toShortDto).collect(toList());
    }
}