package com.shop.service;

import com.shop.dto.BasketProductDto;
import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;
import com.shop.dto.ValueProductFeatureDto;
import com.shop.dto.comment.ProductCommentDto;
import com.shop.entity.Product;
import com.shop.entity.ProductComment;
import com.shop.exception.ProductNotFoundException;
import com.shop.mapper.CommentMapper;
import com.shop.mapper.ProductMapper;
import com.shop.mapper.ValueProductFeatureMapper;
import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ValueProductFeatureMapper valueProductFeatureMapper;
    private final CommentMapper commentMapper;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper,
                              ValueProductFeatureMapper valueProductFeatureMapper, CommentMapper commentMapper
    ) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.valueProductFeatureMapper = valueProductFeatureMapper;
        this.commentMapper = commentMapper;
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(ProductNotFoundException::new);


        List<ProductCommentDto> sortedComments = product.getProductComment().stream()
                .sorted(Comparator.comparing(ProductComment::getDate))
                .map(commentMapper::toDto)
                .collect(toList());

        List<ValueProductFeatureDto> productFeatures = product.getValueProductFeature().stream()
                .map(valueProductFeatureMapper::toDto).collect(toList());


        return productMapper.toDto(product, productFeatures, sortedComments);
    }


    @Override
    public List<ProductShortDto> getProductsByName(String name) {

        List<Product> products = productRepository.findByName(name);


        return products.stream().map(productMapper::toShortDto).collect(toList());
    }


    @Override
    public List<ProductShortDto> getProductByDiscount(Pageable page) {
        List<Product> products = productRepository.findProductsByDiscount(page);

        if (products.isEmpty())
            throw new ProductNotFoundException("Продукт со скидкой не найден");

        return products.stream().map(productMapper::toShortDto).collect(toList());
    }


    @Override
    public List<BasketProductDto> getProductsForBasketByIds(String ids) {
        if (isNull(ids) || ids.equals(""))
            return null;

        String[] string = ids.split(",");

        List<Long> idsList = new ArrayList<>();
        for (String s : string) {
            idsList.add(Long.valueOf(s));
        }

        List<Product> productList = productRepository.findAllById(new HashSet<>(idsList));
        if (productList.isEmpty())
            return null;

        Map<Long, Long> resultMap = new HashMap<>();
        idsList.forEach(e -> resultMap.compute(e, (k, v) -> v == null ? 1L : v + 1L));

        List<ProductShortDto> productShortDtoList = productList.stream().map(productMapper::toShortDto).collect(toList());

        return productShortDtoList.stream()
                .map(p -> productMapper.toBasketDto(p, resultMap.get(p.getId()).intValue()))
                .collect(toList());
    }
}
