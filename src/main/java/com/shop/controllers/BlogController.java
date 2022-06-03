package com.shop.controllers;

import com.shop.dto.CategoryDto;
import com.shop.dto.DtoWithPages;
import com.shop.dto.FullBlogDto;
import com.shop.dto.ShortBlogDto;
import com.shop.dto.comment.BlogReviewCommentDto;
import com.shop.service.BlogCommentService;
import com.shop.service.BlogService;
import com.shop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("model")
public class BlogController {

    private final ProductTypeService productTypeService;
    private final BlogService blogService;
    private final BlogCommentService blogCommentService;


    @Autowired
    public BlogController(
            ProductTypeService productTypeService,
            BlogService blogService,
            BlogCommentService blogCommentService
    ) {
        this.productTypeService = productTypeService;
        this.blogService = blogService;
        this.blogCommentService = blogCommentService;
    }


    @GetMapping("blog/{id}")
    public String getBlogDetails(Model model, @PathVariable Long id) {

        Pageable page = PageRequest.of(0, 8);
        List<CategoryDto> categories = productTypeService.getCategories(page);
        model.addAttribute("categories", categories);

        FullBlogDto fullBlog = blogService.getFullBlog(id);
        model.addAttribute("fullBlog", fullBlog);

        List<ShortBlogDto> blogsLimit = blogService.getBlogsByCategoryWithLimit(fullBlog.getCategory(), 3).stream()
                .filter(blog ->
                        !blog.getId().equals(fullBlog.getId())).collect(Collectors.toList());

        model.addAttribute("blogsLimit", blogsLimit);

        List<ShortBlogDto> newBlogs = blogService.getNewBlogs().stream()
                .filter(blog -> !blog.getId().equals(fullBlog.getId()))
                .collect(Collectors.toList());

        model.addAttribute("newBlogs", newBlogs);

        model.addAttribute("commentDto", new BlogReviewCommentDto());

        return "blog-details";
    }


    @GetMapping("blogs")
    public String getBlogDetails1(Model model, @RequestParam(value = "p", required = false, defaultValue = "1") Integer p) {

        Pageable page = PageRequest.of(0,8);
        List<CategoryDto> categories = productTypeService.getCategories(page);
        model.addAttribute("categories", categories);

        List<ShortBlogDto> newBlogs = blogService.getNewBlogs();

        model.addAttribute("newBlogs", newBlogs);

        Pageable page2 = PageRequest.of(p-1,2, Sort.by("date"));

        DtoWithPages<List<ShortBlogDto>> blogs = blogService.getBlogs(page2);

        model.addAttribute("blogs", blogs.getDto());
        model.addAttribute("countPages", blogs.getPage() + 1);
        model.addAttribute("currentPage", page2.getPageNumber() + 1);

        return "blog-fullwidth";
    }


    @PostMapping("/blog/{id}")
    public RedirectView comment(@ModelAttribute("review") BlogReviewCommentDto blogReviewCommentDto, @PathVariable Integer id) {
        blogCommentService.saveComment(blogReviewCommentDto, id);

        return new RedirectView("/model/blog/" + id);
    }
}
