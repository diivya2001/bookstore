package com.example.books.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
    private static final String message = "Resource Not found";

    public ResourceNotFoundException() {
        super(message);
    }
}
