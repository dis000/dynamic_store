package com.shop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
public class ProductDto {
    public String name;
    public BigDecimal price;
    List<ValueProductFeatureValueDto> features;

}
