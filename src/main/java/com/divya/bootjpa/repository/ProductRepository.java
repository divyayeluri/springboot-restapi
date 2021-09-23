package com.divya.bootjpa.repository;

import com.divya.bootjpa.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    Optional<Product> findByName(String name);
}
