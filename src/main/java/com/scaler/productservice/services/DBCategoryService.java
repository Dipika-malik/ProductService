package com.scaler.productservice.services;

import com.scaler.productservice.dtos.CategoryDto;
import com.scaler.productservice.dtos.GenericProductDto;
import com.scaler.productservice.exceptions.NotFoundExceptions;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service
public class DBCategoryService implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DBCategoryService(CategoryRepository categoryRepository , ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public CategoryDto getCategoryById(long id) throws NotFoundExceptions {
        Optional<Category> category = categoryRepository.findById(id);
        return convertToCategoryDto(category.get());
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categories) {
            categoryDtos.add(convertToCategoryDto(category));
        }
        return categoryDtos;
    }

    private CategoryDto convertToCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        List<GenericProductDto> productDtos= new ArrayList<>();
        if (category.getProducts() != null) {
            for (Product product : category.getProducts()) {
                productDtos.add(ProductToGenericProductDTO(product)); // or product.getId() if you want IDs
            }
        }

        categoryDto.setProducts(productDtos);
        return categoryDto;
    }

    private GenericProductDto ProductToGenericProductDTO(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        Category category = product.getCategory();
        genericProductDto.setId(product.getId());
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setCategory(category.getName());
        genericProductDto.setPrice(product.getPrice());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setDescription(product.getDescription());
        return genericProductDto;
    }

}
