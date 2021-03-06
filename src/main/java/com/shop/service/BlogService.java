package com.shop.service;

import com.shop.dto.DtoWithPages;
import com.shop.dto.FullBlogDto;
import com.shop.dto.ShortBlogDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    FullBlogDto getFullBlog(Long id);

    ShortBlogDto getShortBlog(Long id);

    List<ShortBlogDto> getBlogsByCategoryWithLimit(String category, Integer limit);



    DtoWithPages<List<ShortBlogDto>> getBlogsByName(String name, Pageable pageable);

    DtoWithPages<List<ShortBlogDto>> getBlogsByCategory(String category, Pageable pageable);

    List<ShortBlogDto> getBlogsWithLimit(Integer limit);

    List<ShortBlogDto> getNewBlogs();

    DtoWithPages<List<ShortBlogDto>> getBlogs(Pageable page);
}
