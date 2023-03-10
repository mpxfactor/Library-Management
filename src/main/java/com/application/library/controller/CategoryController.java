package com.application.library.controller;

import com.application.library.entity.Category;
import com.application.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> findAllCategories(){
        return categoryService.findAllCategories();
    }

    @GetMapping("/remove-category/{id}")
    public List<Category> deleteCategory(@PathVariable Long id ){
        categoryService.deleteCategory(id);
        return categoryService.findAllCategories();
    }

    @GetMapping("/update-category/{id}")
    public Category updateCategory(@PathVariable Long id){
        return categoryService.findCategoryById(id);
    }

    @PostMapping("/update-category/{id}")
    public void saveCategory(@PathVariable Long id, Category category){
        categoryService.updateCategory(category);
    }

    @PostMapping("/save-category")
    public List<Category> saveCategory(Category category){
        categoryService.createCategory(category);
        return categoryService.findAllCategories();
    }


}
