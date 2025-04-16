package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.GenericProductDto;
import com.scaler.productservice.exceptions.NotFoundExceptions;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    // constructorinjection in spring
    public ProductController(@Qualifier("DBProductService") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("{id}")
    public GenericProductDto getProductByID(@PathVariable int id) throws NotFoundExceptions {
        return productService.getProductByID(id);
    }
    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("{id}")
    public GenericProductDto deleteProduct(@PathVariable int id) throws NotFoundExceptions {
        return productService.deleteProduct(id);
    }

    @PutMapping("{id}")
    public GenericProductDto updateProduct(@PathVariable int id, @RequestBody GenericProductDto product) {
        return productService.updateProduct(id,product);
    }
}
