package com.example.books.service;

import com.example.books.model.Book;
import com.example.books.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService
{
    User authenticate(User user);

    User register(User user);

}
