package com.tap.patterndesign.Services;

import java.util.List;

import com.tap.patterndesign.Entity.Product;
import com.tap.patterndesign.Repository.ProductRepository;
import com.tap.patterndesign.Repository.ProductRepositoryImpl;

public class ProductService {
     private ProductRepository repo = new ProductRepositoryImpl();

    public void registerProduct(Product p) {
        repo.save(p);
    }

    public void showAllProducts() {
        List<Product> products = repo.findAll();
        products.forEach(p -> System.out.println(p.getName()));
    }
}
