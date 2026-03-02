package com.tap.example.RestAPITesting.Catelog.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tap.example.RestAPITesting.Catelog.Model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> products=new ArrayList<>(Arrays.asList(
            new Product(1, "Dell", 14000),
            new Product(2, "HP", 340000),
            new Product(3, "Acer", 45000)));

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
       return products.stream()
       .filter(p->p.getId()==id)
       .findFirst()
       .orElse(null);
    }


    @Override
    public boolean addProduct(Product p) {
      products.add(p);
      return true;
    }

    @Override
    public boolean updateProduct(Product p, int id) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId() == p.getId()) {
                product.setName(p.getName());
                product.setPrice(p.getPrice());
                // update other fields if needed
                return true ;

            }
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        return removed;
    }
    
}
