package com.application.library.controller;

import com.application.library.entity.Author;
import com.application.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    private List<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }

//    @GetMapping("/remove-author/{id}")
//    public void removeAuthor(@PathVariable Long id) {
//        authorService.deleteAuthor(id);
//    }
//
//    @GetMapping("/update-author/{id}")
//    public Author updateAuthor(@PathVariable Long id) {
//        return authorService.findAuthorById(id);
//    }
//
//    @PostMapping("/update-author/{id}")
//    public void saveUpdateAuthor(@PathVariable Long id, Author author) {
//        authorService.updateAuthor(author);
//    }
//
//    @PostMapping("/save-author")
//    public void saveAuthor(Author author) {
//        authorService.createAuthor(author);
//
//    }
//

}
