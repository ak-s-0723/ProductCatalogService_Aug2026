package org.example.productcatalogservice_auug2026.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatalogservice_auug2026.dtos.ProductDto;
import org.example.productcatalogservice_auug2026.models.Product;
import org.example.productcatalogservice_auug2026.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ProductControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void TestGetProductDetailsByIdAPI_WithValidId_RunSuccessfully() throws Exception {
        //Arrange
        Product product = new Product();
        product.setId(2L);
        product.setName("MacBook");
        when(productService.getProductDetailsById(2L)).thenReturn(product);

        ProductDto productDto = new ProductDto();
        productDto.setId(2L);
        productDto.setName("MacBook");
        String expectedResponse = objectMapper.writeValueAsString(productDto);
        System.out.println(expectedResponse);


        mockMvc.perform(get("/products/2"))    //Act
                .andExpect(status().isOk())             //Assert
                .andExpect(content().string(expectedResponse)); //Assert
                //{"id" : 2,"name" : "MacBook"}  == {"id" : 2,"name" : "MacBook"}
    }
}


//{"id" : 2, "name" : "MacBook"}