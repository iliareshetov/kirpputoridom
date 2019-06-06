package com.example.hyperlearner.controller;


import com.example.hyperlearner.dto.BookCreateDTO;
import com.example.hyperlearner.model.Book;
import com.example.hyperlearner.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {


    @Autowired
    private BookService bookService;


    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "all_books";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        BookCreateDTO booksForm = new BookCreateDTO();

        for (int i = 1; i <= 3; i++) {
            booksForm.addBook(new Book());
        }

        model.addAttribute("form", booksForm);
        return "create_books_form";
    }



    @GetMapping("/edit")
    public String showEditForm(Model model) {
        List<Book> books = new ArrayList<>();
        books.iterator().forEachRemaining(books::add);

        model.addAttribute("form", new BookCreateDTO(books));
        return "edit_books_form";
    }

    @PostMapping("/save")
    public String saveBooks(@ModelAttribute BookCreateDTO form, Model model) {
        bookService.saveBooks(form.getBooks());
        model.addAttribute("books", bookService.findAll());
        return "redirect:/all";
    }
}



