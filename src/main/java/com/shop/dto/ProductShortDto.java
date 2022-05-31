package com.shop.dto;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
//TODO в маппер добавить расчет скидки
public class ProductShortDto {
    private final Long id;
    private final String name;
    private final BigDecimal price;
    private final BigDecimal priceWithoutDiscount;
    private Integer discountPercent;
    private String picture;
}
