package com.shop.service;

import com.shop.entity.Product;
import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements IProductService {


    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductByType(Product product) {

       /* System.out.println("ленивый");
        System.out.println(productRepository.findById(1L).get().getPrice());

        System.out.println("полный");

       productRepository.findById(1L).get().getValueProductCharacteristic().forEach(valueCharacteristic -> System.out.println(valueCharacteristic.getValue()));

        */
   //     return productRepository.findByProductTypeOrderByName(product);
        return null;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product obj) {
        return productRepository.save(obj);
    }

    @Override
    public Optional<Product> getByUuid(Long id) {
        return productRepository.findById(id);
    }

}
