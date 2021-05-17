package com.viniciuschioratto.product.repository;

import com.viniciuschioratto.product.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    Product findById(ObjectId id);
}
