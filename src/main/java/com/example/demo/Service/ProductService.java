package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.*;
import com.example.demo.model.*;
import com.example.demo.Bean.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceRepository priceRepository;

    public void saveProduct(ProductInfo product) {
        productRepository.save(product);
    }

    public void savePrice(ProductPrice productPrice){
        priceRepository.save(productPrice);
    }

    public Optional<ProductPrice> findPriceByProductIdAndTimestamp(String product_id, Double timestamp){
        return priceRepository.findByProductidAndTimestamp(product_id, timestamp);
    }

    public int updatePrice(String productId, Double timestamp, Double newPrice) {
        return priceRepository.updatePriceByProductIdAndTimestamp(newPrice, productId, timestamp);
    }

    public String insertPrice(String productId, Double timestamp, Double newPrice) {
        Optional<ProductPrice> record = priceRepository.findByProductidAndTimestamp(productId, timestamp);

        if(record.isPresent()){
            return "product with the same price and time already exists";
        }else{
            ProductPrice productPrice = new ProductPrice(productId,timestamp,newPrice);
            priceRepository.save(productPrice);
            return "inserted successfully";
        }
    }

    public String deletePrice(String productId, Double timestamp) {
        Optional<ProductPrice> record = priceRepository.findByProductidAndTimestamp(productId,timestamp);
        if(record.isPresent()){
            priceRepository.deleteByProductidAndTimestamp(productId,timestamp);
            return "deleted successfully";
        }else{
            return "timestamp didn't exist";
        }
    }

    public void insertProduct(Product raw_product){
        ProductInfo product = new ProductInfo();
        product.setName(raw_product.getData().get(0).getName());
        product.setProductid(raw_product.getData().get(0).getId());
        product.setShortName(raw_product.getData().get(0).getShortName());
        product.setDataGrouping(raw_product.getData().get(0).isDataGrouping());
        saveProduct(product);
    }
}
