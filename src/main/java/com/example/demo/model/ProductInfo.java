package com.example.demo.model;

import java.util.List;
import com.example.demo.model.ProductPrice;
import jakarta.persistence.*;


@Entity
@Table(name="Product")
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "product_id",unique = true)
    private String product_id;
    private String name;
    private String shortName;
    private boolean dataGrouping;

    // @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    // private List<ProductPrice> priceData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductid() {
        return product_id;
    }

    public void setProductid(String product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public boolean isDataGrouping() {
        return dataGrouping;
    }

    public void setDataGrouping(boolean dataGrouping) {
        this.dataGrouping = dataGrouping;
    }

    // public List<ProductPrice> getPriceData() {
    //     return priceData;
    // }

    // public void setPriceData(List<ProductPrice> priceData) {
    //     this.priceData = priceData;
    // }
}
