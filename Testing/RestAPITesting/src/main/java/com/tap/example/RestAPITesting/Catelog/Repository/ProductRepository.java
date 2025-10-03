package com.tap.example.RestAPITesting.Catelog.Repository;

import java.util.List;

import com.tap.example.RestAPITesting.Catelog.Model.Product;

public interface ProductRepository {

    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public boolean addProduct(Product p);
    public boolean updateProduct(Product p, int id);
    public boolean deleteProduct(int id);
}
