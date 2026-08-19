package org.example.productcatalogservice_auug2026.services;

import org.example.productcatalogservice_auug2026.models.Product;

public interface IProductService {
    Product getProductDetailsById(Long id);

    Product replaceProduct(Long id, Product inputProduct);
}
