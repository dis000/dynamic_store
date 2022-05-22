package com.shop.controllers;

import com.shop.dto.CategoryDto;
import com.shop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
@RequestMapping("model")
public class ThymeLeafController {

    private final ProductTypeService productTypeService;
    @Autowired
    public ThymeLeafController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping("category")
    public String getProductsByCategory(@RequestParam(required = false,defaultValue = "0") int p, Model model) {

        Pageable page = PageRequest.of(p,10);

        List<CategoryDto> categories = productTypeService.getCategories(page);
        model.addAttribute("categories", categories);
        return "index";
    }
}
