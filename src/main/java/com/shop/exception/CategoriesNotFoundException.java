package com.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CategoriesNotFoundException extends ParentException {

    public CategoriesNotFoundException(String message) {
        super(message);
    }

    public CategoriesNotFoundException() {
        super();
    }
}
