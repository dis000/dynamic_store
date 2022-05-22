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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("category")
    public String getProductsByCategory(@RequestParam(required = false,defaultValue = "0") int p, Model model) {

        Pageable page = PageRequest.of(p,8);

        List<CategoryDto> categories = productTypeService.getCategories(page);
        model.addAttribute("categories", categories);



        List<ProductShortDto> productShortDtos0 = productTypeService.getShortByCategory("Видеокарты", page);

        model.addAttribute("productFirst", productShortDtos0);

        List<ProductShortDto> productShortDtos1 = productTypeService.getShortByCategory("Процессоры", page);



        model.addAttribute("productSecond", productShortDtos1);

        List<ProductShortDto> products = productService.getProductByDiscount(page);

        products.forEach(productShortDto -> {
            int percent;
            BigDecimal price = productShortDto.getPrice();
            BigDecimal priceWithoutDiscount = productShortDto.getPriceWithoutDiscount();
            percent = priceWithoutDiscount.subtract(price).divide(priceWithoutDiscount, MathContext.DECIMAL32)
                    .multiply(ONE_HUNDRED).intValue();

            productShortDto.setDiscountPercent(percent);
        });



        model.addAttribute("productsDiscount", products);

        return "index";
    }



    @GetMapping("product/id/{id}")
    public String getProductById(@PathVariable Long id, Model model) {


        ProductDto productDto = productService.getById(id);

/*
        if (isNull(productDto))
            return "404";
*/

        model.addAttribute("product", productDto);
        Pageable page = PageRequest.of(0,8);

        List<CategoryDto> categories = productTypeService.getCategories(page);
        model.addAttribute("categories", categories);

        return "product-details";
    }
}
