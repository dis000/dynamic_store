package com.shop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class ShortBlogDto {
    private final Long id;

    private final String category;

    private final String author;

    private final String date;

    private final String header;

    private final String subtitle;

    private final String picture;

    private final Integer pages;
}
