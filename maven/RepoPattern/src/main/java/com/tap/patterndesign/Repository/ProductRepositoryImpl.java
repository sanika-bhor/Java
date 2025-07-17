package com.tap.patterndesign.Repository;

import java.util.ArrayList;
import java.util.List;

import com.tap.patterndesign.Entity.Product;

public class ProductRepositoryImpl implements ProductRepository {
     @Override
    public void save(Product product) {
        // Use JDBC or JPA to insert/update
        System.out.println("Product saved to DB");
    }

    @Override
    public Product findById(int id) {
        // Retrieve from DB
        return new Product(id, "Sample", 100.0);
    }

    @Override
    public List<Product> findAll() {
      List<Product> products=new ArrayList<Product>();
      products.add(new Product(1, "Pen", 10.0));
     products.add(  new Product(2, "Notebook", 50.0));
     return products;
    }

    @Override
    public void deleteById(int id) {
        System.out.println("Product deleted from DB");
    }
}
