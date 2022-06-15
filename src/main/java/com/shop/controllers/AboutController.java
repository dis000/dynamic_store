package com.shop.controllers;

import com.shop.dto.CategoryDto;
import com.shop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AboutController {


    private final ProductTypeService productTypeService;

    @Autowired
    public AboutController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }


    @GetMapping("about-us")
    public String getContact(Model model) {

        List<CategoryDto> categories = productTypeService.getCategories();
        model.addAttribute("categories", categories);

        return "about-us";
    }
}
