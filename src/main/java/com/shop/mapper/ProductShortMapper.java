package com.shop.mapper;

import com.shop.dto.ProductShortDto;
import com.shop.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductShortMapper {
    ProductShortDto toDto(Product product);
}
