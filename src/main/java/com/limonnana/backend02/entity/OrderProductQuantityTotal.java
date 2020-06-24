package com.limonnana.backend02.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ORDER_PRODUCT_QUANTITY")
public class OrderProductQuantityTotal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_PRODUCT_QUANTITY_ID")
    private Long OrderProductQuantityId;
    private Long productId;
    private String name;
    private String price;
    private Integer quantity;
    private String total;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Long getOrderProductQuantityId() {
        return OrderProductQuantityId;
    }

    public void setOrderProductQuantityId(Long orderProductQuantityId) {
        OrderProductQuantityId = orderProductQuantityId;
    }
}
