package com.shop.service;

import com.shop.entity.ProductType;

public interface IProductTypeService {
    ProductType findByCategory(String category);
}
