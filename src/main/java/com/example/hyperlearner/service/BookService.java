package com.example.hyperlearner.service;

import com.example.hyperlearner.model.Book;
import com.example.hyperlearner.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("bookService")
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void saveBooks(List<Book> books){
        bookRepository.saveAll(books);
    }
}
