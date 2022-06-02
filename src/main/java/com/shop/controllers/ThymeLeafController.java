package com.shop.controllers;

import com.shop.dto.CategoryDto;
import com.shop.dto.FullBlogDto;
import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;
import com.shop.dto.ReviewCommentDto;
import com.shop.dto.ShortBlogDto;
import com.shop.service.BlogCommentService;
import com.shop.service.BlogService;
import com.shop.service.ProductService;
import com.shop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("model")
public class ThymeLeafController {

    private final ProductTypeService productTypeService;
    private final ProductService productService;
    private final BlogService blogService;
    private final BlogCommentService blogCommentService;
    @Autowired
    public ThymeLeafController(ProductTypeService productTypeService, ProductService productService, BlogService blogService, BlogCommentService blogCommentService) {
        this.productTypeService = productTypeService;
        this.productService = productService;
        this.blogService = blogService;
        this.blogCommentService = blogCommentService;
    }
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);


    @GetMapping
    public String getProductsByCategory(@RequestParam(required = false,defaultValue = "0") int p, Model model) {

        Pageable page = PageRequest.of(p,8);
        Pageable pageForMenu = PageRequest.of(0,8);

        List<CategoryDto> categories = productTypeService.getCategories(pageForMenu);
        model.addAttribute("categories", categories);

        List<ProductShortDto> productShortDtos0 = productTypeService.getShortByCategory("Видеокарты", page);
        model.addAttribute("productFirst", productShortDtos0);

        List<ProductShortDto> productShortDtos1 = productTypeService.getShortByCategory("Процессоры", page);
        model.addAttribute("productSecond", productShortDtos1);

        List<ProductShortDto> products = productService.getProductByDiscount(page);
        model.addAttribute("productsDiscount", products);

        List<ShortBlogDto> blogsLimit = blogService.getBlogsWithLimit(6);
        model.addAttribute("blogsLimit", blogsLimit);

        return "index";
    }


    @GetMapping("product/{id}")
    public String getProductById(@PathVariable Long id, Model model) {


        ProductDto productDto = productService.getById(id);
        model.addAttribute("productDetail", productDto);



        Pageable page = PageRequest.of(0,8);
        List<CategoryDto> categories = productTypeService.getCategories(page);
        model.addAttribute("categories", categories);


        Pageable page2 = PageRequest.of(0,8);
        List<ProductShortDto> similarProducts = productTypeService.getShortByCategory(productDto.getCategory(), page);

        model.addAttribute("products", similarProducts);

        return "product-details";
    }


    @GetMapping("categories")
    public String getCategories(Model model) {
        Pageable page = PageRequest.of(0,8);
        List<CategoryDto> categories = productTypeService.getCategories(page);
        model.addAttribute("categories", categories);

        return "categories";
    }


    @GetMapping("category/{category}")
    public String getProductsByCategory(Model model, @NotNull @PathVariable String category) {

        Pageable page = PageRequest.of(0,8);
        List<CategoryDto> categories = productTypeService.getCategories(page);
        model.addAttribute("categories", categories);


        List<ProductShortDto> products = productTypeService.getShortByCategory(category, page);
        model.addAttribute("products", products);

        return "search";
    }


    @GetMapping("search")
    public String searchProduct(Model model, @Param("name") String name) {

        Pageable page = PageRequest.of(0,8);
        List<CategoryDto> categories = productTypeService.getCategories(page);
        model.addAttribute("categories", categories);

        List<ProductShortDto> productsByName = productService.getProductsByName(name);
        model.addAttribute("products", productsByName);

        return "search";
    }


    @GetMapping("blog/{id}")
    public String getBlogDetails(Model model, @PathVariable Long id) {

        Pageable page = PageRequest.of(0,8);
        List<CategoryDto> categories = productTypeService.getCategories(page);
        model.addAttribute("categories", categories);

        FullBlogDto fullBlog = blogService.getFullBlog(id);
        model.addAttribute("fullBlog", fullBlog);

        List<ShortBlogDto> blogsLimit = blogService.getBlogsByCategoryWithLimit(fullBlog.getCategory(), 3).stream()
                .filter(blog ->
                        !blog.getId().equals(fullBlog.getId())).collect(Collectors.toList());

        model.addAttribute("blogsLimit", blogsLimit);

        List<ShortBlogDto> newBlogs = blogService.getNewBlogs().stream()
                .filter(blog ->
                        !blog.getId().equals(fullBlog.getId())).collect(Collectors.toList());

        model.addAttribute("newBlogs", newBlogs);

        model.addAttribute("commentDto", new ReviewCommentDto());

        return "blog-details";
    }


    @GetMapping("blogs")
    public String getBlogDetails1(Model model, @RequestParam(value = "id", required = false, defaultValue = "1") int id) {

        Pageable page = PageRequest.of(0,8);
        List<CategoryDto> categories = productTypeService.getCategories(page);
        model.addAttribute("categories", categories);

        List<ShortBlogDto> newBlogs = blogService.getNewBlogs();

        model.addAttribute("newBlogs", newBlogs);

        Pageable page2 = PageRequest.of(id-1,6);

        List<ShortBlogDto> blogs = blogService.getBlogs(page2);

        model.addAttribute("blogs", blogs);

        return "blog-fullwidth";
    }


    @PostMapping("/blog/{id}")
    public RedirectView comment(@ModelAttribute("review") ReviewCommentDto reviewCommentDto, @PathVariable Integer id) {
        blogCommentService.saveComment(reviewCommentDto, id);

        return new RedirectView("/model/blog/" + id);
    }
}
