package com.shop.controllers;

import com.shop.dto.CategoryDto;
import com.shop.dto.DoubleWrapper;
import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;
import com.shop.service.ProductService;
import com.shop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("model")
public class ThymeLeafController {

    private final ProductTypeService productTypeService;
    private final ProductService productService;
    @Autowired
    public ThymeLeafController(ProductTypeService productTypeService, ProductService productService) {
        this.productTypeService = productTypeService;
        this.productService = productService;
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
}
