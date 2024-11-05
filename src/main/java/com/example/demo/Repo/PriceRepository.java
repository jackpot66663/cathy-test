package com.example.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.ProductPrice;

import jakarta.transaction.Transactional;
import java.util.List;


public interface PriceRepository extends JpaRepository<ProductPrice, Long>{
    @Query("SELECT p FROM ProductPrice p WHERE p.product_id = :product_id AND p.timestamp = :timestamp")
    Optional<ProductPrice> findByProductidAndTimestamp(@Param("product_id") String product_id,@Param("timestamp") Double timestamp);

    @Transactional
    @Modifying
    @Query("UPDATE ProductPrice p SET p.price = :price WHERE p.product_id = :product_id AND p.timestamp = :timestamp")
    int updatePriceByProductIdAndTimestamp(@Param("price") Double price, @Param("product_id") String productId, @Param("timestamp") Double timestamp);


    @Transactional
    @Modifying
    @Query("DELETE FROM ProductPrice p WHERE p.product_id = :product_id AND p.timestamp = :timestamp")
    int deleteByProductidAndTimestamp(@Param("product_id") String product_id,@Param("timestamp") Double timestamp);

}
