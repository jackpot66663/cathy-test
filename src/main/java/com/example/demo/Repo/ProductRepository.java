package com.example.demo.Repo;

import com.example.demo.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, Long>{
    
}