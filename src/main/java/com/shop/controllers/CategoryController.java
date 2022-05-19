package com.shop.controllers;

import com.shop.dto.CategoryDto;
import com.shop.dto.ProductShortDto;
import com.shop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CategoryController {



    private final ProductTypeService productTypeService;
    @Autowired
    public CategoryController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping("category")
    public ResponseEntity<List<CategoryDto>> getProductsByCategory(@RequestParam(required = false,defaultValue = "0") int p) {

        Pageable page = PageRequest.of(p,10);

        List<CategoryDto> categories = productTypeService.getCategories(page);

        return ResponseEntity.ok(categories);
    }


    @GetMapping("category/{category}")
    public ResponseEntity<List<ProductShortDto>> getProductsByCategory(@PathVariable String category,
                                                                       @RequestParam(required = false,defaultValue = "0") int p) {

        Pageable page = PageRequest.of(p,5);

        List<ProductShortDto> productPage = productTypeService.getShortByCategory(category, page);


        return ResponseEntity.ok(productPage);
    }
}
