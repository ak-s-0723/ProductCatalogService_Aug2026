package org.example.productcatalogservice_auug2026.repos;

import org.example.productcatalogservice_auug2026.models.Category;
import org.example.productcatalogservice_auug2026.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    public void testFetchTypes() {
        Optional<Category> categoryOptional = categoryRepo.findById(5000L); //hardcoded 1 row
        Category category = categoryOptional.get();
        for(Product product : category.getProducts()) {
            System.out.println(product.getName());
        }
    }


    @Test
    @Transactional
    public void testNPlusOneProblem() {
        List<Category> categoryList = categoryRepo.findAll();
        for(Category category : categoryList) {
            for(Product product : category.getProducts()) {
                System.out.println(product.getName());
            }
        }
    }

}