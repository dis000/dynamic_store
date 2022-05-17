package com.shop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class ProductShortDto {
    public Long id;
    public String name;
    public BigDecimal price;
}
