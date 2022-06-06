package com.shop.service;

import com.shop.entity.BlogCategory;
import com.shop.repository.BlogCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCategoryServiceImpl implements BlogCategoryService {

    private final BlogCategoryRepository blogCategoryRepository;

    @Autowired
    public BlogCategoryServiceImpl(BlogCategoryRepository blogCategoryRepository) {
        this.blogCategoryRepository = blogCategoryRepository;
    }


    @Override
    public List<BlogCategory> getAllCategories() {
        return blogCategoryRepository.findAll();
    }
}
