package com.limonnana.backend02.entity;

import java.util.Map;

public class OrderDTO {

 private Long userId;
 private Map<Long, Integer> productsQuantities;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<Long, Integer> getProductsQuantities() {
        return productsQuantities;
    }

    public void setProductsQuantities(Map<Long, Integer> productsQuantities) {
        this.productsQuantities = productsQuantities;
    }
}
