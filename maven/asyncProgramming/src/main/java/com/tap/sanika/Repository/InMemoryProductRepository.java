package com.tap.sanika.Repository;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import com.tap.sanika.Entity.Product;

public class InMemoryProductRepository implements IProductRepository {
    private final List<Product> products = Collections.synchronizedList(new ArrayList<>());

    @Override
    public CompletableFuture<Void> addProduct(Product product) {
        return CompletableFuture.runAsync(() -> {
            simulateDelay();
            products.add(product);
        });
    }

    @Override
    public CompletableFuture<Optional<Product>> getProductById(int id) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay();
            return products.stream().filter(p -> p.getId() == id).findFirst();
        });
    }

    @Override
    public CompletableFuture<List<Product>> getAllProducts() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay();
            return new ArrayList<>(products);
        });
    }

    @Override
    public CompletableFuture<Void> updateProduct(Product updatedProduct) {
        return CompletableFuture.runAsync(() -> {
            simulateDelay();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == updatedProduct.getId()) {
                    products.set(i, updatedProduct);
                    return;
                }
            }
        });
    }

    @Override
    public CompletableFuture<Boolean> deleteProduct(int id) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay();
            return products.removeIf(p -> p.getId() == id);
        });
    }

    private void simulateDelay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
