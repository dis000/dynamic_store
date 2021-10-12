package com.shop.service;

import com.shop.entity.Product;
import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public Product getProductByType(Product product) {

       /* System.out.println("ленивый");
        System.out.println(productRepository.findById(1L).get().getPrice());

        System.out.println("полный");

       productRepository.findById(1L).get().getValueProductCharacteristic().forEach(valueCharacteristic -> System.out.println(valueCharacteristic.getValue()));

        */
        return productRepository.findByProductTypeOrderByName(product);
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product create(Product obj) {
        return null;
    }

    @Override
    public Product getByUuid(UUID uuid) {
        return null;
    }

}
