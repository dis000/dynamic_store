package com.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoWithPages <T>{
    private final T dto;
    private final Integer page;
}
