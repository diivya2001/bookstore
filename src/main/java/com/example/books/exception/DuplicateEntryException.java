package com.example.books.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateEntryException extends RuntimeException{
    public DuplicateEntryException(String Message)
    {
        super(Message);
    }
}
