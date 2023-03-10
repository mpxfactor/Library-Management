package com.application.library.controller;

import com.application.library.entity.Book;
import com.application.library.service.AuthorService;
import com.application.library.service.BookService;
import com.application.library.service.CategoryService;
import com.application.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book findBook(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/remove-book/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

//    @GetMapping("/update-book/{id}")
//    public HashMap<String, Object> updateBook(@PathVariable Long id) {
//        HashMap<String, Object> map = new HashMap<>();
//        var category = categoryService.findAllCategories();
//        var publisher = publisherService.findAllPublishers();
//        var author = authorService.findAllAuthors();
//        var books = bookService.findBookById(id);
//
//        map.put("book", books);
//        map.put("category", category);
//        map.put("publisher", publisher);
//        map.put("author", author);
//
//        return map;
//    }

    @PutMapping("/save-update/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book){
        bookService.updateBook(book);
    }

//    @GetMapping("/add-book")
//    public HashMap<String, Object> addBook() {
//        HashMap<String, Object> map = new HashMap<>();
//        var category = categoryService.findAllCategories();
//        var publisher = publisherService.findAllPublishers();
//        var author = authorService.findAllAuthors();
//        map.put("category", category);
//        map.put("publisher", publisher);
//        map.put("author", author);
//
//        return map;
//    }

    @PostMapping("/save-book")
    public void saveBook(@RequestBody Book book){
        System.out.println("authors" + book.getAuthors().toString()  + "/n" + "categories" + book.getCategories());
        bookService.createBook(book);
    }
}
