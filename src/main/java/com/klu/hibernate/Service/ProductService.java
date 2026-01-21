package com.klu.hibernate.Service;


import com.klu.hibernate.Entity.Product;
import com.klu.hibernate.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }
    public void addMultipleProducts(List<Product> products) {
        repo.saveAll(products);
    }
    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }
    public Product updateQuantity(Long id, int newQty) {
        Product p = repo.findById(id).orElse(null);
        if (p == null) return null;
        p.setQuantity(newQty);
        return repo.save(p);
    }

    // New: Update price
    public Product updatePrice(Long id, double newPrice) {
        Product p = repo.findById(id).orElse(null);
        if (p == null) return null;
        p.setPrice(newPrice);
        return repo.save(p);
    }

    // Delete by id
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}
