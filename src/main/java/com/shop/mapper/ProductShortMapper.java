package com.shop.mapper;

import com.shop.dto.ProductShortDto;
import com.shop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductShortMapper {
    ProductShortDto toDto(Product product);
}
