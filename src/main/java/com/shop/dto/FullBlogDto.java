package com.shop.dto;

import com.shop.dto.comment.BlogCommentDto;
import com.shop.entity.BlogDetails;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter
@Builder
@ToString
public class FullBlogDto {

    private final Long id;

    private final String category;

    private final String author;

    private final String date;

    private final String header;

    private final String subtitle;

    private final String picture;

    private final List<BlogCommentDto> blogComment;

    private final Set<BlogDetails> blogDetails;

}
