package org.example.productcatalogservice_auug2026.controllers;

import org.example.productcatalogservice_auug2026.dtos.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    public ProductDto getProductDetailsById(@PathVariable("id") Long productId)
    {

    }
}
