package com.shop.service;

import com.shop.entity.Product;

import java.util.List;
import java.util.Optional;


public interface IProductService {

     Product getProductByType(Product product);
     List<Product> getAll();
     Product create(Product obj);
     Optional<Product> getByUuid(Long id);

}
