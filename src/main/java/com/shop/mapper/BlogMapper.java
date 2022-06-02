package com.shop.mapper;

import com.shop.dto.CommentDto;
import com.shop.dto.FullBlogDto;
import com.shop.dto.ShortBlogDto;
import com.shop.entity.Blog;
import com.shop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.shop.controllers.ThymeLeafController.ONE_HUNDRED;
import static java.util.Objects.isNull;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    @Mapping(target = "date", expression = "java(changeDateToString(blog))")
    ShortBlogDto toShortDto(Blog blog);

    @Mapping(target = "date", expression = "java(changeDateToString(blog))")
    @Mapping(source = "comments", target = "blogComment")
    FullBlogDto toDto(Blog blog, List<CommentDto> comments);


    default String changeDateToString(Blog blog) {

        LocalDateTime date = blog.getDate();
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

}
