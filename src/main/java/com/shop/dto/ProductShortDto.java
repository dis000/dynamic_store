package com.shop.dto;



import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class ProductShortDto {
    private final Long id;
    private final String name;
    private final BigDecimal price;
}
