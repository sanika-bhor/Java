package com.tap.example.RestAPITesting.Catelog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.example.RestAPITesting.Catelog.Model.Product;
import com.tap.example.RestAPITesting.Catelog.Services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    private ProductService _srv;

    @Autowired
    public ProductController(ProductService srv)
    {
        _srv=srv;
    }

    @GetMapping
    public List<Product> getAllProducts()
    {
        return _srv.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return _srv.getProductById(id);
    }

    @PostMapping
    public boolean createProduct(@RequestBody Product product) {
        return _srv.addProduct(product);
      
    }

    @PutMapping("/{id}")
    public boolean updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        return _srv.updateProduct(updatedProduct,id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable int id) {
       return _srv.deleteProduct(id);
    }
}
