package com.shop.controllers;

import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;
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

    // взять продукт
    @GetMapping("product")
    public ResponseEntity<ProductDto> getFullProductById(@RequestParam long id) {
        ProductDto productDto = productService.getById(id);

        if (isNull(productDto)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("product_feature")
    public ResponseEntity<List<ProductDto>> getByProductFeature(@RequestParam String feature) {
        List<ProductDto> productDtos = productService.getProductsByName(feature);

        if (productDtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productDtos);
    }
//done
    @GetMapping("category/{category}")
    public ResponseEntity<List<ProductShortDto>> getProductsByCategory(@PathVariable String category,
                                                               @RequestParam(required = false,defaultValue = "0") int p) {

        Pageable page = PageRequest.of(p,2);

        List<ProductShortDto> productPage = productService.getShortByCategory(category, page);

        if (productPage.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(productPage);
    }
   // @GetMapping("category/{category}")



}
