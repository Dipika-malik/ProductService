package com.scaler.productservice.services;

import com.scaler.productservice.dtos.GenericProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.exceptions.NotFoundExceptions;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("DBProductService")
public class DBProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DBProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public GenericProductDto getProductByID(long id) throws NotFoundExceptions {

        Optional<Product> products = Optional.ofNullable(productRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions("Record with ID : " + id + " Not available in the record")));
        return convertGenericProductDTO(products);
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return getAllGenericProductDto(products);
    }

    @Override

    public GenericProductDto createProduct(GenericProductDto genericProductDto) {

        Product product = constructProductDTO(genericProductDto);
        productRepository.save(product);
        return genericProductDto;
    }

    @Override
    public GenericProductDto deleteProduct(long id) throws NotFoundExceptions {
        GenericProductDto genericProductDto;
        Optional<Product> products = Optional.ofNullable(productRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptions("Record with ID  : " + id + " Not available in the record, Cannot delete record")));
        genericProductDto = convertGenericProductDTO(products);
        productRepository.deleteById(id);
        return genericProductDto;

    }

    @Override
    public GenericProductDto updateProduct(long id, GenericProductDto genericProduct) {
        Product product = constructProductDTO(genericProduct);
        product.setId(id);
        productRepository.save(product);
        return genericProduct;
    }

    private List<GenericProductDto> getAllGenericProductDto(List<Product> products) {
        List<GenericProductDto> genericProductDtoList = new ArrayList<>();
        for (Product product : products) {
            GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto.setId(product.getId());
            Category category = product.getCategory();
            genericProductDto.setCategory(category.getName());
            genericProductDto.setPrice(product.getPrice());
            genericProductDto.setImage(product.getImage());
            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setTitle(product.getTitle());
            genericProductDtoList.add(genericProductDto);
        }

        return genericProductDtoList;
    }

    private Product constructProductDTO(GenericProductDto genericProductDto) {
        Product product = new Product();
        product.setDescription(genericProductDto.getDescription());
        product.setImage(genericProductDto.getImage());
        product.setPrice(genericProductDto.getPrice());
        product.setTitle(genericProductDto.getTitle());

        Category category = new Category();
        category.setName(genericProductDto.getCategory());
        product.setCategory(category);
        return product;
    }


    private GenericProductDto convertGenericProductDTO(Optional<Product> products) throws NotFoundExceptions {
        GenericProductDto genericProductDto = new GenericProductDto();
        Category category = products.get().getCategory();
        genericProductDto.setId(products.get().getId());
        genericProductDto.setTitle(products.get().getTitle());
        genericProductDto.setCategory(category.getName());
        genericProductDto.setPrice(products.get().getPrice());
        genericProductDto.setImage(products.get().getImage());
        genericProductDto.setDescription(products.get().getDescription());
        genericProductDto.setTitle(products.get().getTitle());
        return genericProductDto;
    }
}
