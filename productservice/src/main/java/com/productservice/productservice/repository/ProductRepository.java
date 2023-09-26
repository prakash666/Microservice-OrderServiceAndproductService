package com.productservice.productservice.repository;

import com.productservice.productservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Product,String> {                          // Reasons of extends MongoRepositr
}
