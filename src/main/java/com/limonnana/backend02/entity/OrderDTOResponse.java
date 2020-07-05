package com.limonnana.backend02.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderDTOResponse {

    private Long orderId;
    private User user;
    private List<OrderProductQuantityTotal> orderProductQuantityTotal = new ArrayList<>();
    private String totalTotal;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderProductQuantityTotal> getOrderProductQuantityTotal() {
        return orderProductQuantityTotal;
    }

    public void setOrderProductQuantityTotal(List<OrderProductQuantityTotal> orderProductQuantityTotal) {
        this.orderProductQuantityTotal = orderProductQuantityTotal;
    }

    public String getTotalTotal() {
        return totalTotal;
    }

    public void setTotalTotal(String totalTotal) {
        this.totalTotal = totalTotal;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
