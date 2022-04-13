package com.shop.service;

import com.shop.entity.ProductType;

import java.util.Set;

public interface IProductTypeService {
    ProductType getByCategory(String category);

}
