package com.limonnana.backend02.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "THE_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;

    @OneToMany(targetEntity=OrderProductQuantityTotal.class, fetch = FetchType.EAGER, orphanRemoval = false, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "ORDER_PRODUCT",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORDER_PRODUCT_QUANTITY_ID")
    )
    private List<OrderProductQuantityTotal> productList = new ArrayList<>();


    private String totalTotal;
    private String created;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    private String discount;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTotalTotal() {
        return totalTotal;
    }

    public void setTotalTotal(String totalTotal) {
        this.totalTotal = totalTotal;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


    public List<OrderProductQuantityTotal> getProductList() {
        return productList;
    }

    public void setProductList(List<OrderProductQuantityTotal> productList) {
        this.productList = productList;
    }
}
