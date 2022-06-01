package com.shop.mapper;


import com.shop.dto.CategoryDto;
import com.shop.entity.ProductType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductTypeMapper {

    @Mapping(source = "productType.picture", target = "picture", defaultExpression = "java(\"/assets/img/product/no-image.jpg\")")
    @Mapping(source = "productType.nameCategory", target = "name")
    CategoryDto toDto(ProductType productType);

}
