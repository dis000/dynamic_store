package com.shop.exception;

public class ProductNotFoundException extends ParentException{

    private final static String message = "Продукт не найден";

    public ProductNotFoundException() {
        super(message);
    }


    public ProductNotFoundException(String message) {
        super(message);
    }
}
