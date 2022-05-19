package com.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class ValueProductFeatureDto {
    // ProductFeature name
    String featureName;
    //valueProductFeature value
    String value;
}
