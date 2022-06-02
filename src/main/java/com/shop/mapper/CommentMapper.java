package com.shop.mapper;

import com.shop.dto.CommentDto;
import com.shop.entity.Blog;
import com.shop.entity.BlogComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "date", expression = "java(changeDateToString(comment))")
    CommentDto toDto(BlogComment comment);

    default String changeDateToString(BlogComment comment) {

        LocalDateTime date = comment.getDate();
        return String.format("%s %d:%d",
                date.format(DateTimeFormatter.ISO_LOCAL_DATE),
                date.getHour(),
                date.getMinute());
    }
}
