package com.shop.mapper;

import com.shop.dto.ValueProductFeatureDto;
import com.shop.entity.ValueProductFeature;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ValueProductFeatureMapper {

    @Mapping(source = "valueProductFeature.productFeature.name", target = "featureName")
    ValueProductFeatureDto toDto(ValueProductFeature valueProductFeature);

}
