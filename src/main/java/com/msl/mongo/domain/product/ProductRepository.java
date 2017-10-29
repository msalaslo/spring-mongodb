package com.msl.mongo.domain.product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    public Product findById(String id);
    public List<Product> findByName(String name);
    public List<Product> findByDescription(String description);
    public List<Product> findAll();

}
