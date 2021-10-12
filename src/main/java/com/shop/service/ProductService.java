package com.shop.service;

import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;



    public void get () {

        System.out.println("ленивый");
        System.out.println(productRepository.findById(1L).get().getPrice());



        System.out.println("полный");
        productRepository.findById(1L).get().getValueProductCharacteristic().forEach(valueCharacteristic -> System.out.println(valueCharacteristic.getValue()));
    }

}
