package com.shop.mapper;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "product.price", target = "price")
    ProductDto toDto(Product product);
    Product FromDto(ProductDto productDto);
}
