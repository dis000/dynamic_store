package com.shop.controllers;

import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }


    @GetMapping("product")
    public ResponseEntity<ProductDto> getFullProductById(@RequestParam long id) {
        ProductDto productDto = productService.getById(id);

        return ResponseEntity.ok(productDto);
    }


    @GetMapping("search_by_name")
    public ResponseEntity<List<ProductShortDto>> getByProductByName(@RequestParam String name) {
        List<ProductShortDto> productDtos = productService.getProductsByName(name);

        return ResponseEntity.ok(productDtos);
    }
}
