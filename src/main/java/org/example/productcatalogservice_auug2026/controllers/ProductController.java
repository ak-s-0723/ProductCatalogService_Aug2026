package org.example.productcatalogservice_auug2026.controllers;

import org.example.productcatalogservice_auug2026.dtos.CategoryDto;
import org.example.productcatalogservice_auug2026.dtos.ProductDto;
import org.example.productcatalogservice_auug2026.models.Category;
import org.example.productcatalogservice_auug2026.models.Product;
import org.example.productcatalogservice_auug2026.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;


    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductDetailsById(@PathVariable("id") Long productId)
    {
            if (productId <= 0L) {
                //return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
                throw new IllegalArgumentException("Please pass id > 0");
            }

            Product product = productService.getProductDetailsById(productId);
            if (product == null)
                throw new RuntimeException("Product is not available"); //return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

            ProductDto productDto = from(product);
            return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> replaceProduct(@PathVariable Long id,
                                                    @RequestBody ProductDto
                                                            productDto) {
        Product inputProduct  = from(productDto);
        inputProduct.setId(id);
        Product output = productService.replaceProduct(id,inputProduct);
        ProductDto responseProductDto =  from(output);
        return new ResponseEntity<>(responseProductDto,HttpStatus.OK);
    }

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setName(productDto.getCategory().getName());
            category.setId(productDto.getCategory().getId());
            product.setCategory(category);
        }
        return product;
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setId(product.getId());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setDescription(product.getCategory().getDescription());
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            productDto.setCategory(categoryDto);
        }

        return productDto;
    }
}




/*
bean =  singleton object whose lifecycle is being controller by Spring
If you want to tell spring to create a bean of any class - you just annotate that class
with some annotation like @RestController or @Service or @Component or @Configuration

Spring context is the name of the bowl or  vessel or container in which spring
store all the beans.
 */