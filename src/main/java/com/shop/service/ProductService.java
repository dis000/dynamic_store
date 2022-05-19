package com.shop.service;

import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;
import com.shop.dto.ValueProductFeatureDto;
import com.shop.entity.Product;
import com.shop.entity.ProductFeature;
import com.shop.entity.ValueProductFeature;
import com.shop.exception.ProductNotFoundException;
import com.shop.mapper.ProductShortMapper;
import com.shop.mapper.ValueProductFeatureMapper;
import com.shop.mapper.ProductMapper;
import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@Service
public class ProductService implements IProductService {


    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ValueProductFeatureMapper valueProductFeatureMapper;
    private final ProductShortMapper productShortMapper;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          ProductMapper productMapper,
                          ValueProductFeatureMapper valueProductFeatureMapper,
                          ProductShortMapper productShortMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.valueProductFeatureMapper = valueProductFeatureMapper;
        this.productShortMapper = productShortMapper;
    }

    @Override
    public Product getProductByType(Product product) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product obj) {
        return productRepository.save(obj);
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);


        List<ValueProductFeatureDto> productFeatures = product.getValueProductFeature().stream().map(valueProductFeatureMapper::toDto).collect(toList());


        return productMapper.toDto(product, productFeatures);
    }

    @Override
    public List<ProductShortDto> getProductsByName(String name) {

        Set<Product> products = productRepository.findByName(name);

        return products.stream().map(productShortMapper::toDto).collect(toList());
    }

    @Override
    public List<ProductShortDto> getShortByCategory(String category, Pageable page) {
        return productRepository.findProductsByCategory(category, page).stream()
                .map(productShortMapper::toDto)
                .collect(Collectors.toList());

    }
}
