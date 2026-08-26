package org.example.productcatalogservice_auug2026.services;

import org.example.productcatalogservice_auug2026.models.Product;
import org.example.productcatalogservice_auug2026.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductDetailsById(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if(productOptional.isPresent()) {
            return productOptional.get();
        }

        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product inputProduct) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product with id "+id+" doesn't exists");
        }

        inputProduct.setId(id);
        inputProduct.setLastUpdatedAt(new Date());
        return productRepo.save(inputProduct);
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Product> productOptional = productRepo.findById(product.getId());
        if (productOptional.isPresent()) {
            throw new RuntimeException("Product with id "+product.getId()+" already exists");
        }

        return productRepo.save(product);

    }
}

//GetAllProducts -> findAll()   //ToDo : must
//deleteProduct  -> deleteById(id)   //ToDo : must
//updateProduct  -> save()
