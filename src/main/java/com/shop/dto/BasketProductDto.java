package com.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class BasketProductDto {
    private final ProductShortDto productShortDto;
    private final Integer howMany;
}
