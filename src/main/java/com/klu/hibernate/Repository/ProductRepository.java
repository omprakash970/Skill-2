package com.klu.hibernate.Repository;

import com.klu.hibernate.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
