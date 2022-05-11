package com.shop.service;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface IProductService {

     Product getProductByType(Product product);
     List<Product> getAll();
     Product create(Product obj);
     ProductDto getById(Long id);
     List<ProductDto> getProductsByName(String name);



     List<Product> getByCategory(String category, Pageable page);
}
