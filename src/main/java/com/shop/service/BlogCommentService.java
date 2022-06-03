package com.shop.service;

import com.shop.dto.comment.BlogReviewCommentDto;

public interface BlogCommentService {
    void saveComment(BlogReviewCommentDto blogReviewCommentDto, Integer id);
}
