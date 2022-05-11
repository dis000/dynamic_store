package com.shop.controllers;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import com.shop.service.IProductService;
import com.shop.service.IProductTypeService;
import com.shop.service.IValueProductFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
public class ProductController {

    IProductService productService;
    IProductTypeService productTypeService;
    IValueProductFeatureService valueProductFeatureService;

    @Autowired
    public ProductController(IProductService productService,
                             IProductTypeService productTypeService,
                             IValueProductFeatureService valueProductFeatureService) {
        this.productService = productService;
        this.productTypeService = productTypeService;
        this.valueProductFeatureService = valueProductFeatureService;
    }

    @GetMapping("product{id}")
    public ResponseEntity<ProductDto> getFullProductById(@RequestParam long id) {
        ProductDto productDto = productService.getById(id);

        if (isNull(productDto)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("product_feature")
    public ResponseEntity<List<ProductDto>> getByProductFeature() {
        List<ProductDto> productDtos = productService.getProductsByName("gtx 10610");

        if (productDtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productDtos);
    }
//done
    @GetMapping("category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category,
                                                               @RequestParam(required = false,defaultValue = "0") int p) {

        Pageable page = PageRequest.of(p,2);

        List<Product> productPage = productService.getByCategory(category, page);

        if (productPage.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(productPage);
    }



}
