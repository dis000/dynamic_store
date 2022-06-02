package com.shop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CommentDto {
    private Long id;

    private final String author;

    private final String date;

    private final String text;


}
