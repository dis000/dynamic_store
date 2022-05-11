package com.shop.mapper;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "product.price", target = "price")
    @Mapping(source = "product.id", target = "id")
    ProductDto toDto(Product product);
    Product FromDto(ProductDto productDto);
}
