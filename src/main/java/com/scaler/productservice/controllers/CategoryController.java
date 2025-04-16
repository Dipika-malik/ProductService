package com.scaler.productservice.controllers;


import com.scaler.productservice.dtos.CategoryDto;
import com.scaler.productservice.exceptions.NotFoundExceptions;
import com.scaler.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDto> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @GetMapping("{id}")
    public CategoryDto getCategoryById(@PathVariable long id) throws NotFoundExceptions {
        return categoryService.getCategoryById(id);

    }


}
