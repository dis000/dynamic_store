package com.shop.service;

import com.shop.dto.CategoryDto;
import com.shop.dto.ProductShortDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductTypeService {

    List<CategoryDto> getCategories(Pageable page);

    List<ProductShortDto> getShortByCategory(String category, Pageable page);

}
