package com.scaler.productservice.services;

import com.scaler.productservice.dtos.GenericProductDto;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    @Override
    public GenericProductDto getProductByID(int id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(int id) {
        return null;
    }

    @Override
    public GenericProductDto updateProduct(int id, GenericProductDto product) {
        return null;
    }
}
