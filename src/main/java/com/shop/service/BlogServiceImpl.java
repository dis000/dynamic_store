package com.shop.service;

import com.shop.dto.CommentDto;
import com.shop.dto.FullBlogDto;
import com.shop.dto.ShortBlogDto;
import com.shop.entity.Blog;
import com.shop.entity.BlogComment;
import com.shop.exception.BlogNotFoundException;
import com.shop.mapper.BlogMapper;
import com.shop.mapper.CommentMapper;
import com.shop.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;
    private final CommentMapper commentMapper;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, BlogMapper blogMapper, CommentMapper commentMapper) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
        this.commentMapper = commentMapper;
    }

    @Override
    public FullBlogDto getFullBlog(Long id) {
        Blog blog = blogRepository.findFullBlog(id).orElseThrow(BlogNotFoundException::new);


        List<CommentDto> comments = blog.getBlogComment().stream()
                .map(commentMapper::toDto).collect(toList());
        return blogMapper.toDto(blog, comments);
    }

    @Override
    public ShortBlogDto getShortBlog(Long id) {
        Blog blog = blogRepository.findShortBlog(id).orElseThrow(BlogNotFoundException::new);

        return blogMapper.toShortDto(blog);
    }

    @Override
    public List<ShortBlogDto> getBlogsByCategoryWithLimit(String category, Integer limit) {
        List<Blog> blogs = blogRepository.findBlogsByCategoryWithLimit(category, limit);

        return blogs.stream().map(blogMapper::toShortDto).collect(toList());
    }

    @Override
    public List<ShortBlogDto> getBlogsWithLimit(Integer limit) {
        List<Blog> blogs = blogRepository.findBlogsWithLimit(limit);
        return blogs.stream().map(blogMapper::toShortDto).collect(toList());
    }

    @Override
    public List<ShortBlogDto> getNewBlogs() {
        List<Blog> blogs = blogRepository.findNewBlogs();
        return blogs.stream().map(blogMapper::toShortDto).collect(toList());
    }

    @Override
    public List<ShortBlogDto> getBlogs(Pageable page) {
        List<Blog> blogs = blogRepository.findAllBlogs(page);
        return blogs.stream().map(blogMapper::toShortDto).collect(toList());
    }
}
