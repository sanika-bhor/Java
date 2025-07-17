package com.tap.patterndesign.Repository;

import java.util.List;

import com.tap.patterndesign.Entity.Product;

public interface ProductRepository {
    void save(Product product);

    Product findById(int id);

    List<Product> findAll();

    void deleteById(int id);
}