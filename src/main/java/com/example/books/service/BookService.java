package com.example.books.service;

import com.example.books.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService
{
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book addBook(Book book);

    String updateBook(long id, Book book);

    boolean deleteBook(long id);


}
