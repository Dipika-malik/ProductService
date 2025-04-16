package com.scaler.productservice.services;

import com.scaler.productservice.dtos.CategoryDto;
import com.scaler.productservice.exceptions.NotFoundExceptions;

import java.util.List;

public interface CategoryService {
    CategoryDto getCategoryById(long id) throws NotFoundExceptions;
    List<CategoryDto> getAllCategories();


}
