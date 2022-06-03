package com.shop.dto.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductReviewCommentDto {
    String comment;
    String name;
    Integer rating;
}
