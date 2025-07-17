package com.tap.patterndesign.Main;

import com.tap.patterndesign.Entity.Product;
import com.tap.patterndesign.Services.ProductService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Product product=new Product(3,"pencil",5.0);
        ProductService srv=new ProductService();
        srv.registerProduct(product);
        srv.showAllProducts();
    }
}
