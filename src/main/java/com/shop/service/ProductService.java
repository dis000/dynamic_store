package com.shop.service;

import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;
import com.shop.entity.Product;
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
        Product product = productRepository.findById(id).orElse(null);

        //TODO бросить exception not found


        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDto> getProductsByName(String name) {

        Set<Product> products = productRepository.findByName(name);

        List<ProductDto> productDtos = products.stream().map(product -> {
            ProductDto productDto = productMapper.toDto(product);
            productDto.setFeatures(product.getValueProductFeature().stream().map(valueProductFeatureMapper::toDto).collect(toList()));
            return productDto;
        }).collect(toList());

        return productDtos;
    }

    @Override
    public List<ProductShortDto> getShortByCategory(String category, Pageable page) {
        return productRepository.findProductsByCategory(category, page).stream()
                .map(productShortMapper::toDto)
                .collect(Collectors.toList());

    }
}
