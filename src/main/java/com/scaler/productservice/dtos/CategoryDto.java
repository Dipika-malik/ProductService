package com.scaler.productservice.dtos;


import com.scaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class CategoryDto {
    private Long id;
    private String name;
    private List<GenericProductDto> products;

}
