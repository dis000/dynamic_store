package com.shop.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategoryDto {
    private final String name;
    private final String picture;
}
