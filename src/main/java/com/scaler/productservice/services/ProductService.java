package com.scaler.productservice.services;

import com.scaler.productservice.dtos.GenericProductDto;
import com.scaler.productservice.exceptions.NotFoundExceptions;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductByID(int id) throws NotFoundExceptions;
    List<GenericProductDto> getAllProducts();
    GenericProductDto createProduct(GenericProductDto product);
    GenericProductDto deleteProduct(int id) throws NotFoundExceptions;
    GenericProductDto updateProduct(int id,GenericProductDto product);



}
