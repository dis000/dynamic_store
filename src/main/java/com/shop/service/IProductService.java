package com.shop.service;

import com.shop.entity.Product;

import java.util.List;
import java.util.UUID;

public interface IProductService {

     Product getProductByType(Product product);
     List<Product> getAll();
     Product create(Product obj);
     Product getByUuid(UUID uuid);

}
