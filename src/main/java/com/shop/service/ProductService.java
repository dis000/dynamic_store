package com.shop.service;

import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;

import java.util.List;


public interface ProductService {

     ProductDto getById(Long id);
     List<ProductShortDto> getProductsByName(String name);




}
