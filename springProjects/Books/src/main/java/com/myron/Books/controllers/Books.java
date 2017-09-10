package com.myron.Books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myron.Books.models.Book;
import com.myron.Books.services.BookService;

@Controller
public class Books {
    private final BookService bookService;
    public Books(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/books")
    public String books(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        if (result.hasErrors()) {
            return "books.jsp";
        }else{
        	bookService.addBook(book);
            return "redirect:/books";
        }
     
    }
    
    @RequestMapping("/books/{index}")
    public String findBookByIndex(Model model, @PathVariable("index") int index) {
        Book book = bookService.findBookByIndex(index);
        model.addAttribute("book", book);
        return "showBook.jsp";
    }
    
    @RequestMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.findBookByIndex(id);
        if (book != null){
            model.addAttribute("book", book);
            model.addAttribute("id", id);
            return "editBook.jsp";
        }else{
            return "redirect:/books";
        }
    }
    
    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "editBook.jsp";
        }else{
            bookService.updateBook(id, book);
            return "redirect:/books";
        }
    }
    
    @RequestMapping(value="/books/delete/{id}")
    public String destroyBook(@PathVariable("id") int id) {
        bookService.destroyBook(id);
        return "redirect:/books";
    }
}
