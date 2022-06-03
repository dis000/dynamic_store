package com.shop.service;

import com.shop.dto.comment.ProductReviewCommentDto;

public interface ProductCommentService {
    public void saveComment(ProductReviewCommentDto productReviewCommentDto, Long id);
}
