package com.caforero.springapi.controllers;

import com.caforero.springapi.models.Product;
import com.caforero.springapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Optional<Product> product = productService.getProduct(id);
        return product.isPresent() ? ResponseEntity.ok(product.get()) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,
                                                 @RequestBody @Valid Product product) {

        Optional<Product> optionalProduct = productService.getProduct(id);

        if(optionalProduct.isPresent()){
            Product editProduct = optionalProduct.get();
            editProduct.setName(product.getName());
            productService.updateProduct(editProduct);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
