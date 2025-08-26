package com.tap.sanika.Main;

import java.util.List;

import com.tap.sanika.Entity.Product;
import com.tap.sanika.Repository.*;

/**
 * Hello world!
 *
 */
public class App 
{
  
    public static void main(String[] args) throws Exception {
        IProductRepository repo = new InMemoryProductRepository();

        // Add Products
        repo.addProduct(new Product(1, "Laptop", 79999)).get();
        repo.addProduct(new Product(2, "Phone", 29999)).get();

        // Get All
        List<Product> all = repo.getAllProducts().get();
        System.out.println("All Products: " + all);

        // Update
        repo.updateProduct(new Product(2, "Smartphone", 24999)).get();

        // Get by ID
        Product p = repo.getProductById(2).get().orElse(null);
        System.out.println("Product with ID 2: " + p);

        // Delete
        repo.deleteProduct(1).get();

        // Final List
        System.out.println("Final Products: " + repo.getAllProducts().get());
    }
}

