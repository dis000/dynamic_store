package com.shop.exception;

public class ParentException extends RuntimeException{
    public ParentException(String message) {
        super(message);
    }


    public ParentException() {
        super();
    }
}
