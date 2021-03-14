package com.viniciuschioratto.product.service;

import com.viniciuschioratto.product.entity.Product;
import com.viniciuschioratto.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<String> insertNewProduct(Product newProduct) {
        try {
            productRepository.insert(newProduct);
            System.out.println("New Product was inserted.");
            return ResponseEntity.status(HttpStatus.OK).body("Inserted with success");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error to Insert");
        }
    }

    public ResponseEntity<String> deleteProduct(String idProduct) {
        try {
            productRepository.deleteById(UUID.fromString(idProduct));
            System.out.println("Product with Id:" + idProduct + " was deleted.");
            return ResponseEntity.status(HttpStatus.OK).body("Deleted with success");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error to delete the product.");
        }
    }

    public ResponseEntity<Product> updateProduct(Product newProduct, String idOldProduct) {
        try {
            Product oldProduct = productRepository.findFirstById(UUID.fromString(idOldProduct));
//            if () {
//                oldProduct.setName(newProduct.getName());
//                oldProduct.setDescription(newProduct.getDescription());
//
//                productRepository.save(oldProduct);
//            }
            System.out.println("New Product was inserted.");
            return ResponseEntity.status(HttpStatus.OK).body(oldProduct);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(newProduct);
        }
    }

    public ResponseEntity<Product> getProduct(String idProduct) {
        try {
            Product productRequested = productRepository.findFirstById(UUID.fromString(idProduct));
            System.out.println("New Product was inserted.");
            return ResponseEntity.status(HttpStatus.OK).body(productRequested);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
}
