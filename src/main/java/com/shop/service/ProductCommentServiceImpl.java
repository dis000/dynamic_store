package com.shop.service;

import com.shop.dto.comment.ProductReviewCommentDto;
import com.shop.entity.ProductComment;
import com.shop.exception.ProductNotFoundException;
import com.shop.mapper.CommentMapper;
import com.shop.repository.ProductCommentRepository;
import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentServiceImpl implements ProductCommentService {
    private final ProductCommentRepository productCommentRepository;
    private final CommentMapper commentMapper;
    private final ProductRepository productRepository;


    @Autowired
    public ProductCommentServiceImpl(ProductCommentRepository productCommentRepository, CommentMapper commentMapper,
            ProductRepository productRepository
    ) {
        this.productCommentRepository = productCommentRepository;
        this.commentMapper = commentMapper;
        this.productRepository = productRepository;
    }


    @Override
    public void saveComment(ProductReviewCommentDto productReviewCommentDto, Long id) {
        ProductComment productComment = commentMapper.toEntity(productReviewCommentDto, id);
        productComment.setProduct(productRepository.findById(id).orElseThrow(ProductNotFoundException::new));
        productCommentRepository.save(productComment);
    }
}
