package com.caforero.springapi.services;

import com.caforero.springapi.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getProducts();

    public Optional<Product> getProduct(Long id);

    public void createProduct(Product product);

    public void deleteProduct(Long id);

    public void updateProduct(Product product);
}
