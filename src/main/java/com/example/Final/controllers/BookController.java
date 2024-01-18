package com.example.Final.controllers;

import com.example.Final.data.BookRepository;
import com.example.Final.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String displayAllBooks(Model model) {
        model.addAttribute("title", "All Books");
        model.addAttribute("books", bookRepository.findAll());
        return "books/index";
    }

    @GetMapping("create")
    public String displayCreateBookForm(Model model) {
        model.addAttribute("title", "Create Book");
        model.addAttribute("book", new Book()); // Use "book" as the model attribute
        return "books/create";
    }

    @PostMapping("create")
    public String processCreateBookForm(@ModelAttribute("book") @Validated Book newBook, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Book");
            return "books/create";
        } else {
            bookRepository.save(newBook);
            return "redirect:/books";
        }
    }

    @GetMapping("delete")
    public String displayDeleteBookForm(Model model) {
        model.addAttribute("title", "Delete Books");
        model.addAttribute("books", bookRepository.findAll());
        return "books/delete";
    }

    @PostMapping("delete")
    public String processDeleteBookForm(@RequestParam(name = "bookIds", required = false) Integer[] bookIds) {
        if (bookIds != null) {
            for (Integer id : bookIds) {
                if (id != null) {
                    bookRepository.deleteById(id);
                }
            }
        }
        return "redirect:/books";
    }

    @GetMapping("replace/{id}")
    public String displayReplaceBookForm(@PathVariable int id, Model model) {
        Optional<Book> existingBook = bookRepository.findById(id);

        if (existingBook.isPresent()) {
            model.addAttribute("title", "Replace Book");
            model.addAttribute("existingBook", existingBook.get());
            model.addAttribute("book", new Book()); // Use "book" as the model attribute
            return "books/replace";
        } else {
            return "redirect:/books";
        }
    }

    @PostMapping("replace/{id}")
    public String processReplaceBookForm(
            @PathVariable int id,
            @ModelAttribute("book") @Validated Book newBook,
            Errors errors,
            Model model
    ) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Replace Book");
            return "books/replace";
        } else {
            Optional<Book> existingBook = bookRepository.findById(id);

            if (existingBook.isPresent()) {
                Book bookToUpdate = existingBook.get();
                bookToUpdate.setTitle(newBook.getTitle());
                bookToUpdate.setAuthor(newBook.getAuthor());
                bookRepository.save(bookToUpdate);
                return "redirect:/books";
            } else {
                return "redirect:/books";
            }
        }
    }
}
