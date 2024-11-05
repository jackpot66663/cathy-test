package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.FundService;
import com.example.demo.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.example.demo.Bean.*;
import com.example.demo.model.*;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private FundService fundService;
    @Autowired
    private ProductService productService;

    @GetMapping("/getData")
    public String get_Data() {
        String json = fundService.getFundNavChart();
        Gson gson = new Gson();
        Product raw_product = gson.fromJson(json, Product.class);
        // System.out.println(raw_product.getStatusCode());
        // System.out.println(raw_product.getMessage());

        ProductInfo product = new ProductInfo();
        product.setName(raw_product.getData().get(0).getName());
        product.setProductid(raw_product.getData().get(0).getId());
        product.setShortName(raw_product.getData().get(0).getShortName());
        product.setDataGrouping(raw_product.getData().get(0).isDataGrouping());
        productService.saveProduct(product);

        List<List<Double>> lists = raw_product.getData().get(0).getData();
        for(List<Double> p:lists){
            ProductPrice productPrice = new ProductPrice(raw_product.getData().get(0).getId(),p.get(0),p.get(1));
            productService.savePrice(productPrice);
        }

        return json;
    }

    @GetMapping("/search")
    public ResponseEntity<Double> searchPricebyIDandTime(@RequestParam String product_id,
            @RequestParam Double timestamp){
                return productService.findPriceByProductIdAndTimestamp(product_id, timestamp)
                        .map(productPrice -> ResponseEntity.ok(productPrice.getPrice()))
                        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/update")
    public ResponseEntity<String> updatePricebyIDandTime(@RequestParam String product_id,
        @RequestParam Double timestamp,@RequestParam Double price){
            int row = productService.updatePrice(product_id, timestamp, price);
            if (row>0){
                return ResponseEntity.ok("updated successfully");
            }else{
                return ResponseEntity.notFound().build();
            }         
    }

    @GetMapping("/insert")
    public ResponseEntity<String> insertPricebyIDandTime(@RequestParam String product_id,
        @RequestParam Double timestamp,@RequestParam Double price){
            String result = productService.insertPrice(product_id, timestamp, price);
            if (result.equals("inserted successfully")){
                return ResponseEntity.ok("inserte successfully");
            }else{
                return ResponseEntity.badRequest().body(result);
            }         
    }
    
    @GetMapping("/delete")
    public ResponseEntity<String> deletePricebyTime(@RequestParam String product_id,
        @RequestParam Double timestamp) {
            String result = productService.deletePrice(product_id,timestamp);
            if (result.equals("deleted successfully")){
                return ResponseEntity.ok("delete successfully");
            }else{
                return ResponseEntity.badRequest().body(result);
            }
    }

    @GetMapping("/rate")
    public String changePricebyTimeStamp(@RequestParam String product_id,
        @RequestParam Double timestamp1,@RequestParam Double timestamp2){
            if(timestamp2<=timestamp1){
                return "input dates are invalid";
            }
            Optional<ProductPrice> p1 = productService.findPriceByProductIdAndTimestamp(product_id, timestamp1);
            Optional<ProductPrice> p2 = productService.findPriceByProductIdAndTimestamp(product_id, timestamp2);

            if(!p1.isPresent()||!p2.isPresent()){
                return "can't find product price according to dates";
            }
            // System.out.println(p1.get().getPrice());

            JSONObject result = new JSONObject();
            double diff = p2.get().getPrice()-p1.get().getPrice();
            String diff_format = String.format("%.5f", diff);
            result.put("漲跌",diff_format);

            double rate = diff/p1.get().getPrice()*100;
            String rate_format = String.format("%.5f",rate);
            result.put("漲跌幅",rate_format);

            return result.toString();
    }
    
    
}
