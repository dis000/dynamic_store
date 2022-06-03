package com.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MyEnumException extends ParentException {
    public MyEnumException(String message) {
        super(message);
    }

    public MyEnumException() {
    }
}
