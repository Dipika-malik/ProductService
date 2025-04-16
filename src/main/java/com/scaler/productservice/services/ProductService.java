package com.scaler.productservice.services;

import com.scaler.productservice.dtos.GenericProductDto;
import com.scaler.productservice.exceptions.NotFoundExceptions;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductByID(long id) throws NotFoundExceptions;
    List<GenericProductDto> getAllProducts();
    GenericProductDto createProduct(GenericProductDto product);
    GenericProductDto deleteProduct(long id) throws NotFoundExceptions;
    GenericProductDto updateProduct(long id,GenericProductDto product);



}
