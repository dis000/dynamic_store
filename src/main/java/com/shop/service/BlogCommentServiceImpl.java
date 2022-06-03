package com.shop.service;

import com.shop.dto.comment.BlogReviewCommentDto;
import com.shop.entity.BlogComment;
import com.shop.exception.BlogNotFoundException;
import com.shop.repository.BlogCommentRepository;
import com.shop.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BlogCommentServiceImpl implements BlogCommentService {

    private final BlogCommentRepository blogCommentRepository;
    private final BlogRepository blogRepository;


    @Autowired
    public BlogCommentServiceImpl(BlogCommentRepository blogCommentRepository, BlogRepository blogRepository) {
        this.blogCommentRepository = blogCommentRepository;
        this.blogRepository = blogRepository;
    }


    @Override
    public void saveComment(BlogReviewCommentDto blogReviewCommentDto, Integer id) {
        BlogComment blogComment = BlogComment.builder()
                .blog(blogRepository.findShortBlog(id.longValue()).orElseThrow(BlogNotFoundException::new))
                .author(blogReviewCommentDto.getName())
                .date(LocalDateTime.now())
                .text(blogReviewCommentDto.getComment())
                .id(null)
                .build();

        blogCommentRepository.save(blogComment);
    }
}
