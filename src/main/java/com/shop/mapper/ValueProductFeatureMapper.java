package com.shop.mapper;

import com.shop.dto.ProductDto;
import com.shop.dto.ValueProductFeatureValueDto;
import com.shop.entity.Product;
import com.shop.entity.ValueProductFeature;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ValueProductFeatureMapper {
    //valueProductFeature value
    @Mapping(source = "valueProductFeature.value", target = "value")
    @Mapping(source = "valueProductFeature.productFeature.name", target = "featureName")
    ValueProductFeatureValueDto toDto(ValueProductFeature valueProductFeature);
    Product FromDto(ProductDto productDto);
}
