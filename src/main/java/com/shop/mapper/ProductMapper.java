package com.shop.mapper;

import com.shop.dto.ProductDto;
import com.shop.dto.ProductShortDto;
import com.shop.dto.ValueProductFeatureDto;
import com.shop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import static com.shop.controllers.ThymeLeafController.ONE_HUNDRED;
import static java.util.Objects.isNull;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "product.picture", target = "picture", defaultExpression = "java(\"/assets/img/product/no-image.jpg\")")
    @Mapping(target = "discountPercent", expression = "java(calculatePercent(product))")
    ProductShortDto toShortDto(Product product);

    @Mapping(source = "product.picture", target = "picture", defaultExpression = "java(\"/assets/img/product/no-image.jpg\")")
    @Mapping(target = "discountPercent", expression = "java(calculatePercent(product))")
    @Mapping(source = "product.productType.nameCategory", target = "category")
    ProductDto toDto(Product product, List<ValueProductFeatureDto> features);


    default Integer calculatePercent(Product product) {
        if (isNull(product.getPriceWithoutDiscount()) || isNull(product.getPrice()))
            return null;

        int percent;
        BigDecimal price = product.getPrice();
        BigDecimal priceWithoutDiscount = product.getPriceWithoutDiscount();
        percent = priceWithoutDiscount.subtract(price).divide(priceWithoutDiscount, MathContext.DECIMAL32)
                .multiply(ONE_HUNDRED).intValue();

        return percent;
    }
}
