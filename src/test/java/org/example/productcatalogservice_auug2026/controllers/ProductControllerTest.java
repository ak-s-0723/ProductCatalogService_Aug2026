package org.example.productcatalogservice_auug2026.controllers;

import org.example.productcatalogservice_auug2026.dtos.ProductDto;
import org.example.productcatalogservice_auug2026.models.Product;
import org.example.productcatalogservice_auug2026.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;


   @MockBean
    private IProductService productService;

    @Test
    public void TestGetProductDetailsById_WithValidProductId_ReturnProductSuccessfully() {
        //Arrange
        Long productId = 5L;
        Product product = new Product();
        product.setId(productId);
        product.setName("Iphone 17");
        when(productService.getProductDetailsById(productId)).thenReturn(product);


        //Act
        ResponseEntity<ProductDto> productDtoResponseEntity =
                productController.getProductDetailsById(productId);


        //Assert
        assertNotNull(productDtoResponseEntity);
        assertNotNull(productDtoResponseEntity.getBody());
        assertEquals(HttpStatus.OK, productDtoResponseEntity.getStatusCode());
        assertEquals(productId, productDtoResponseEntity.getBody().getId());
        assertEquals("Iphone 17",
                productDtoResponseEntity.getBody().getName());

        verify(productService, times(1))
                .getProductDetailsById(productId);

    }

    @Test
    public void TestGetProductDetailsById_WithNegativeId_ResultsInIllegalArgumentException() {
        //Arrange
        Long productId = -5L;

        //Act and Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                ()-> productController.getProductDetailsById(productId));

        assertEquals("Invalid Product Id", exception.getMessage());

    }

}