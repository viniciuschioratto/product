package com.viniciuschioratto.product.repository;

import com.viniciuschioratto.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, UUID> {

    Product findFirstById(UUID id);
}
