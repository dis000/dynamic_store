package com.shop.controllers;

import com.shop.entity.ValueProductFeature;
import com.shop.service.IProductService;
import com.shop.service.IProductTypeService;
import com.shop.service.IValueProductFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    IProductService productService;
    @Autowired
    IProductTypeService productTypeService;
    @Autowired
    IValueProductFeatureService valueProductFeatureService;

    @GetMapping
    public List<ValueProductFeature> get(){



       return valueProductFeatureService.get("memory");
    }

}
