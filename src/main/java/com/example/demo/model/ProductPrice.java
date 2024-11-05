package com.example.demo.model;

import com.example.demo.model.ProductInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "PriceData")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @ManyToOne
    // @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    // private ProductInfo product;
    private String product_id;
    private Double timestamp;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public ProductPrice() {
    }
    public ProductPrice(String product_id, Double timestamp, Double price) {
        this.product_id = product_id;
        this.timestamp = timestamp;
        this.price = price;
    }

    
    // public ProductInfo getProduct() {
    //     return product;
    // }
    // public void setProduct(ProductInfo product) {
    //     this.product = product;
    // }
    public String getProductid() {
        return product_id;
    }

    public void setProductid(String product_id) {
        this.product_id = product_id;
    }
    public Double getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
