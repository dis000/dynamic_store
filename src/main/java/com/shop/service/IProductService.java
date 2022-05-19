package com.shop.service;

import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;
import com.shop.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IProductService {

     Product getProductByType(Product product);
     List<Product> getAll();
     Product create(Product obj);
     ProductDto getById(Long id);
     List<ProductShortDto> getProductsByName(String name);



     List<ProductShortDto> getShortByCategory(String category, Pageable page);
}
