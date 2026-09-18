package org.example.productcatalogservice_auug2026.repos;

import org.example.productcatalogservice_auug2026.models.Category;
import org.example.productcatalogservice_auug2026.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepoTest {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    //@Test
    public void addDataIntoRds() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Iphone 18 Pro Max");
        product.setPrice(185000D);

        Category category = new Category();
        category.setName("Iphones");
        category.setId(10L);

        categoryRepo.save(category);

        product.setCategory(category);
        productRepo.save(product);
    }
}
