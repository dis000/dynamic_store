package com.shop.mapper;


import com.shop.dto.CategoryDto;
import com.shop.entity.ProductType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductTypeMapper {

    CategoryDto toDto(ProductType productType);

}
