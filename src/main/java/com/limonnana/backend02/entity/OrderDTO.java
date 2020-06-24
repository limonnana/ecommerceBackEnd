package com.limonnana.backend02.entity;

import java.util.Map;

public class OrderDTO {

 private Long userId;
 private Map<String, Integer> productsQuantities;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Map<String, Integer> getProductsQuantities() {
        return productsQuantities;
    }

    public void setProductsQuantities(Map<String, Integer> productsQuantities) {
        this.productsQuantities = productsQuantities;
    }
}
