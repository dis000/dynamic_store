package com.shop.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ValueProductFeatureDto {

    private final String featureName;
    private final String value;
}
