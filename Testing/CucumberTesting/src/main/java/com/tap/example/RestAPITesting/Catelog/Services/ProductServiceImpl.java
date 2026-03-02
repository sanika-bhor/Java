package com.tap.example.RestAPITesting.Catelog.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tap.example.RestAPITesting.Catelog.Model.Product;
import com.tap.example.RestAPITesting.Catelog.Repository.ProductRepository;

@Service
public  class ProductServiceImpl implements ProductService{

    private ProductRepository _srv;
   
    public ProductServiceImpl(ProductRepository srv)
    {
        this._srv=srv;
    }
    @Override
    public List<Product> getAllProducts() {
        return _srv.getAllProducts();
    }

    @Override
    public Product getProductById(int id) {
        return _srv.getProductById(id);
    }

    @Override
    public boolean addProduct(Product p) {
       return _srv.addProduct(p);
    }

    @Override
    public boolean updateProduct(Product p, int id) {
        return _srv.updateProduct(p, id);
    }

    @Override
    public boolean deleteProduct(int id) {
       return _srv.deleteProduct(id);
    }
    
}
