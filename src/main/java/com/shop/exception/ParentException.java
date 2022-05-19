package com.shop.exception;

public abstract class ParentException extends RuntimeException{

    public ParentException(String message) {
        super(message);
    }


    public ParentException() {
        super();
    }
}
