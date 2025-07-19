package com.business.repositories;

import com.business.entities.Product; // ✅ Correct again


import org.springframework.data.jpa.repository.JpaRepository;
import com.business.entities.Product;

@SuppressWarnings("unused")
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
