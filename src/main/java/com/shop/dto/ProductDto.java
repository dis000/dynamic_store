package com.shop.dto;



import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
public class ProductDto {

    private final Long id;
    private final String name;
    private final BigDecimal price;
    private final BigDecimal priceWithoutDiscount;
    private final Integer discountPercent;
    private final String picture;
    private final String category;
    private final Double rating;
    private final List<ValueProductFeatureDto> features;
    private final List<String> pictures;

}
