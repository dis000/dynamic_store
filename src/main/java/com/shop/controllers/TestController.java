package com.shop.controllers;

import com.shop.dto.ProductDto;
import com.shop.entity.ProductType;
import com.shop.service.IProductService;
import com.shop.service.IProductTypeService;
import com.shop.service.IValueProductFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    IProductService productService;
    IProductTypeService productTypeService;
    IValueProductFeatureService valueProductFeatureService;

    @Autowired
    public TestController(IProductService productService,
                          IProductTypeService productTypeService,
                          IValueProductFeatureService valueProductFeatureService) {
        this.productService = productService;
        this.productTypeService = productTypeService;
        this.valueProductFeatureService = valueProductFeatureService;
    }

    @GetMapping("category")
    public ProductType getByCategory(@RequestParam("category") String category) {

        ProductType productType = productTypeService.getByCategory(category.toLowerCase());
        System.out.println(category);
       return productType;
    }
    @GetMapping("product_feature")
    public ResponseEntity<List<ProductDto>> getByProductFeature() {
        List<ProductDto> productDtos = productService.getProductsByName("gtx 10610");

        if (productDtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productDtos);
    }

}
