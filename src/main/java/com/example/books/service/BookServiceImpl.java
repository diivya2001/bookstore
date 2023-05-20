package com.example.books.service;

import com.example.books.exception.DuplicateEntryException;
import com.example.books.exception.ResourceNotFoundException;
import com.example.books.model.Book;
import com.example.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException());
    }

    @Override
    public Book addBook(Book book) {

           try
           {
               return bookRepository.save(book);
           }
           catch (DataIntegrityViolationException ex)
           {
               throw new DuplicateEntryException("Book with Id "+book.getBookId()+"already exists");
           }
    }

    @Override
    public String updateBook(long id, Book book) {
        Book existingBook = getBookById(id);

        if(existingBook != null)
        {
            existingBook.setBookName(book.getBookName());
            existingBook.setBookdescription(book.getBookdescription());
            existingBook.setPrice(book.getPrice());
            existingBook.setAuthorName(book.getAuthorName());
            bookRepository.save(existingBook);
            return "Record updated successfully";
        }
        else
        {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public boolean deleteBook(long id)
    {
        return bookRepository.findById(id).map(book ->
        {
            bookRepository.delete(book);
            return true;
        }).orElseThrow( () -> new ResourceNotFoundException());
    }
}
