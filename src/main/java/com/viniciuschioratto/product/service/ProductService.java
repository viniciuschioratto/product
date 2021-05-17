package com.viniciuschioratto.product.service;

import com.viniciuschioratto.product.entity.Product;
import com.viniciuschioratto.product.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<String> insertNewProduct(Product newProduct) {
        try {
            productRepository.insert(newProduct);
            return ResponseEntity.status(HttpStatus.OK).body("Inserted with success");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error to Insert");
        }
    }

    public ResponseEntity<String> deleteProduct(String idProduct) {
        try {
            productRepository.deleteById(idProduct);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted with success");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error to delete the product.");
        }
    }

    public ResponseEntity<Product> updateProduct(Product newProduct, String idOldProduct) {
        try {
            ObjectId idInMongo = new ObjectId(idOldProduct);
            Product oldProduct = productRepository.findById(idInMongo);
            if (oldProduct != null) {
                oldProduct.setName(newProduct.getName());
                oldProduct.setDescription(newProduct.getDescription());

                productRepository.save(oldProduct);
                return ResponseEntity.status(HttpStatus.OK).body(oldProduct);
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(newProduct);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(newProduct);
        }
    }

    public ResponseEntity<Product> getProduct(String idProduct) {
        try {
            ObjectId idInMongo = new ObjectId(idProduct);
            Product productRequested = productRepository.findById(idInMongo);
            return ResponseEntity.status(HttpStatus.OK).body(productRequested);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
}
