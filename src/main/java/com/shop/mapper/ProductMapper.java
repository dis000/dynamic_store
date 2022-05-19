package com.shop.mapper;

import com.shop.dto.ProductDto;
import com.shop.dto.ValueProductFeatureDto;
import com.shop.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product, List<ValueProductFeatureDto> features);

}
