package com.shop.controllers;

import com.shop.service.IProductService;
import com.shop.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    IProductService productService;
    @Autowired
    IProductTypeService productTypeService;

    @GetMapping
    public String get(){

        productTypeService.findByCategory("VideoCards").getProducts().forEach(product -> System.out.println(product.getName()));

       return "kek";
    }

}
