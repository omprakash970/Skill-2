package com.klu.hibernate;

import com.klu.hibernate.Entity.Product;
import com.klu.hibernate.Service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService service) {
        return args -> {

            // 1) Insert multiple products
            service.addMultipleProducts(List.of(
                    new Product("Laptop", "Gaming laptop", 75000, 5),
                    new Product("Mouse", "Wireless mouse", 1200, 30),
                    new Product("Keyboard", "Mechanical keyboard", 3500, 15)
            ));
            System.out.println("✅ Inserted multiple products");

            // 2) Retrieve by id
            Product p = service.getProductById(1L);
            System.out.println("📌 Retrieved: " + p);

            // 3) Update price
            Product updatedPrice = service.updatePrice(1L, 72000);
            System.out.println("💰 Price Updated: " + updatedPrice);

            // 4) Update quantity
            Product updatedQty = service.updateQuantity(2L, 50);
            System.out.println("📦 Quantity Updated: " + updatedQty);

            // 5) Delete product by id
            service.deleteProduct(3L);
            System.out.println("🗑️ Deleted product with id 3");
        };
    }
}
