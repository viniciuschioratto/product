package com.viniciuschioratto.product.controller;

import com.viniciuschioratto.product.entity.Product;
import com.viniciuschioratto.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Product newProduct) {
        return productService.insertNewProduct(newProduct);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") String idProduct) {
        return productService.deleteProduct(idProduct);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product productToUpdate, @RequestParam("id") String idProduct) {
        return productService.updateProduct(productToUpdate, idProduct);
    }

    @GetMapping
    public ResponseEntity<Product> get(@RequestParam("idProduct") String idProduct) {
        return productService.getProduct(idProduct);
    }

}
