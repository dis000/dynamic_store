package com.shop.controllers;

import com.shop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    IProductService productService;

    @GetMapping
    public String get(){
       productService.get();
       return "kek";
    }

}
