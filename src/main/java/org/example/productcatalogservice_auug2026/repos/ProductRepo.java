package org.example.productcatalogservice_auug2026.repos;

import org.example.productcatalogservice_auug2026.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {

    Optional<Product> findById(Long id);

    Product save(Product product);
}
