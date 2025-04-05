package com.scaler.productservice.services;

import com.scaler.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductByID(int id);
    List<GenericProductDto> getAllProducts();
    GenericProductDto createProduct(GenericProductDto product);
    GenericProductDto deleteProduct(int id);
    GenericProductDto updateProduct(int id,GenericProductDto product);



}
