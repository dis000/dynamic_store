package com.shop.service;

import com.shop.dto.BasketProductDto;
import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {

     ProductDto getById(Long id);
     List<ProductShortDto> getProductsByName(String name);

     List<ProductShortDto> getProductByDiscount(Pageable page);

     List<BasketProductDto> getProductsForBasketByIds(String ids);

}
