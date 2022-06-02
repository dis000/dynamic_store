package com.shop.service;

import com.shop.dto.ReviewCommentDto;

public interface BlogCommentService {
    void saveComment(ReviewCommentDto reviewCommentDto, Integer id);
}
