package com.example.hyperlearner.dto;

import com.example.hyperlearner.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCreateDTO {

    private List<Book> books = new ArrayList<>();


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public BookCreateDTO() {
    }

    public BookCreateDTO(List<Book> books) {
        this.books = books;
    }


    public void addBook(Book book) {
        this.books.add(book);
    }



}
